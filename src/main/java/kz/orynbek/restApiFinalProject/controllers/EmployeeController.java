package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.Dto.EmployeeDTO;
import kz.orynbek.restApiFinalProject.entities.Employee;
import kz.orynbek.restApiFinalProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id")Long id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
    }
    @PutMapping
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
