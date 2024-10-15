package kz.orynbek.restApiFinalProject.repositories;

import jakarta.transaction.Transactional;
import kz.orynbek.restApiFinalProject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findAllById(Long id);
}
