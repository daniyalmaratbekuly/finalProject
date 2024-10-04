package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.entities.Leave;
import kz.orynbek.restApiFinalProject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    @GetMapping
    List<Leave>getAllLeaves() {
        return leaveService.getAllLeaves();
    }
    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }
    @PostMapping
    public void createLeave(@RequestBody Leave leave) {
        leaveService.createLeave(leave);
    }
    @PutMapping
    public void updateLeave(@RequestBody Leave leave) {
        leaveService.updateLeave(leave);
    }
    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeaveById(id);
    }

}
