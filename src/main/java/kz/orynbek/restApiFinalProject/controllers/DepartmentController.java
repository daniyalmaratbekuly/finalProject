package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.entities.Department;
import kz.orynbek.restApiFinalProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id")Long id){
        return departmentService.getDepartmentById(id);
    }
    @PostMapping
    public void createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
    }
    @PutMapping
    public void updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id")Long id){
        departmentService.deleteDepartment(id);
    }



}
