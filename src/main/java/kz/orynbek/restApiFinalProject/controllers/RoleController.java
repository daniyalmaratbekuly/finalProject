package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.entities.Role;
import kz.orynbek.restApiFinalProject.repositories.RoleRepository;
import kz.orynbek.restApiFinalProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    List <Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable("id")Long id) {
        return  roleService.getRoleById(id);
    }
    @PostMapping
    public void createRole(@RequestBody Role role){
        roleService.createRole(role);
    }
    @PutMapping
    public void updateRole(@RequestBody Role role){
        roleService.updateRole(role);
    }
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id")Long id) {
        roleService.deleteRole(id);
    }
}
