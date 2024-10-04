package kz.orynbek.restApiFinalProject.service;

import kz.orynbek.restApiFinalProject.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void createDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Long id);

}
