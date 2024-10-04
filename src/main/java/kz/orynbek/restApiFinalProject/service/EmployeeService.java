package kz.orynbek.restApiFinalProject.service;

import ch.qos.logback.core.read.ListAppender;
import kz.orynbek.restApiFinalProject.Dto.EmployeeDTO;
import kz.orynbek.restApiFinalProject.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    void createEmployee(EmployeeDTO employeeDTO);
    void updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}
