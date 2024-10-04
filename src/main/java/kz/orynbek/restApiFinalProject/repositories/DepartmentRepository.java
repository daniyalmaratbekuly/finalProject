package kz.orynbek.restApiFinalProject.repositories;

import jakarta.transaction.Transactional;
import kz.orynbek.restApiFinalProject.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {
Department findAllById(Long id);
}
