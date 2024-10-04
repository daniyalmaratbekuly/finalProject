package kz.orynbek.restApiFinalProject.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kz.orynbek.restApiFinalProject.Dto.EmployeeDTO;
import kz.orynbek.restApiFinalProject.entities.Employee;
import kz.orynbek.restApiFinalProject.mapper.EmployeeMapper;
import kz.orynbek.restApiFinalProject.repositories.EmployeeRepository;
import kz.orynbek.restApiFinalProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employeeMapper.mapToDto(employees);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeMapper.mapToDto(employeeRepository.findAllById(id));
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee checkEmployee = employeeRepository.findAllByEmailContainsIgnoreCase(employeeDTO.getEmail());
        if (checkEmployee == null) {
            Employee employee = employeeMapper.mapToEntity(employeeDTO);
            employee.setDepartmentId(UUID.randomUUID().toString().substring(0, 4));
            employeeRepository.save(employee);
            sendVerificationEmail(employee.getEmail(),employee.getDepartmentId(),employee.getFullName());
        }


    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findAllById(employeeDTO.getId());
        employee.setFullName(employeeDTO.getFullName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setDepartment1(employeeDTO.getDepartment1());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setTasks(employeeDTO.getTasks());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private void sendVerificationEmail(String to, String departmentId,String fullName) {
        String subject = "Your DepartmentId";
        String text = "Thank you for choosing us." + "Dear" + " " + fullName  + " ." + "Your department id is: " + departmentId;
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
