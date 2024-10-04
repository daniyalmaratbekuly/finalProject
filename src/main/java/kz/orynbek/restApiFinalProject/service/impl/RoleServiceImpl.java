package kz.orynbek.restApiFinalProject.service.impl;

import kz.orynbek.restApiFinalProject.entities.Role;
import kz.orynbek.restApiFinalProject.repositories.RoleRepository;
import kz.orynbek.restApiFinalProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findAllById(id);
    }

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
