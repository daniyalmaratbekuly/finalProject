package kz.orynbek.restApiFinalProject.repositories;

import jakarta.transaction.Transactional;
import kz.orynbek.restApiFinalProject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Employee findAllById(Long id);
Employee findAllByEmailContainsIgnoreCase(String email);

}
