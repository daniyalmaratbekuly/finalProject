package kz.orynbek.restApiFinalProject.auth.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import kz.orynbek.restApiFinalProject.auth.UserRepository;
import kz.orynbek.restApiFinalProject.auth.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findAllByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }
        return user;
    }
    public void register(Users user){
        Users checkUser = userRepository.findAllByEmail(user.getEmail());
        if(checkUser == null){
            if(user.getStatus() == null){
                user.setStatus("non-activated");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String code = UUID.randomUUID().toString().substring(0,4);
            user.setCode(code);
            userRepository.save(user);

            sendVerificationEmail(user.getEmail(),code,user.getFullName());
        }
    }
    public void verify(String code, String email){
        Users user = userRepository.findAllByEmail(email);
        if(code.equals(user.getCode())){
            user.setStatus("activated");
        }
        userRepository.save(user);
    }
    private void sendVerificationEmail(String to, String code,String fullName) {
        String subject = "Your Verification Code";
        String text = "Thank you for registration." + "Dear" + fullName +" Your activation link is: " + "http://localhost:8080/auth/verify?code=" + code + "&email=" + to;

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
