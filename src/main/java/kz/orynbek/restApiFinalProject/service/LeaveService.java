package kz.orynbek.restApiFinalProject.service;

import kz.orynbek.restApiFinalProject.entities.Leave;

import java.util.List;

public interface LeaveService {
    List<Leave>getAllLeaves();
    Leave getLeaveById(Long id);
    void createLeave(Leave leave);
    void updateLeave(Leave leave);
    void deleteLeaveById(Long id);

}
