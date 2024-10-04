package kz.orynbek.restApiFinalProject.service;

import kz.orynbek.restApiFinalProject.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long id);
}
