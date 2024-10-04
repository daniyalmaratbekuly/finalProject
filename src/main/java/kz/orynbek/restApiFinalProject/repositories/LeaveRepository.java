package kz.orynbek.restApiFinalProject.repositories;

import jakarta.transaction.Transactional;
import kz.orynbek.restApiFinalProject.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    Leave findAllById(Long id);
}
