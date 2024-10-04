package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.auth.Users;
import kz.orynbek.restApiFinalProject.auth.services.MyUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private MyUserService userService;
    @PostMapping("/register")
    public void register(@RequestBody Users user) {
        userService.register(user);
    }

    @GetMapping("/verify")
    public void verifyAccount(@RequestParam("code")String code,
                              @RequestParam("email")String email) {
        userService.verify(code, email);
    }
}
