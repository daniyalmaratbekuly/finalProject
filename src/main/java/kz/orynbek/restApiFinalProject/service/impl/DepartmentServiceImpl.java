package kz.orynbek.restApiFinalProject.service.impl;

import kz.orynbek.restApiFinalProject.entities.Department;
import kz.orynbek.restApiFinalProject.repositories.DepartmentRepository;
import kz.orynbek.restApiFinalProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findAllById(id);
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
