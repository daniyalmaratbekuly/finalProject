package kz.orynbek.restApiFinalProject.service.impl;

import kz.orynbek.restApiFinalProject.entities.Leave;
import kz.orynbek.restApiFinalProject.repositories.LeaveRepository;
import kz.orynbek.restApiFinalProject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;
    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave getLeaveById(Long id) {
        return leaveRepository.findAllById(id);
    }

    @Override
    public void createLeave(Leave leave) {
         leaveRepository.save(leave);
    }

    @Override
    public void updateLeave(Leave leave) {
         leaveRepository.save(leave);
    }

    @Override
    public void deleteLeaveById(Long id) {
         leaveRepository.deleteById(id);
    }
}
