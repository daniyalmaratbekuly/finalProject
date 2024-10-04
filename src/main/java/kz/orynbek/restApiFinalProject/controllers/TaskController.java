package kz.orynbek.restApiFinalProject.controllers;

import kz.orynbek.restApiFinalProject.entities.Task;
import kz.orynbek.restApiFinalProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
@Autowired
    private TaskService assignmentService;
   @GetMapping
    public List<Task> getAllAssignments() {
       return assignmentService.getAllTasks();
   }
   @GetMapping("/{id}")
   public Task getAssignmentById(@PathVariable("id")Long id) {
       return assignmentService.getTaskById(id);
   }
   @PostMapping
    public void createAssignment(@RequestBody Task assignment) {
       assignmentService.createTask(assignment);
   }
   @PutMapping
    public void updateAssignment(@RequestBody Task assignment) {
       assignmentService.updateTask(assignment);
   }
   @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable("id")Long id) {
       assignmentService.deleteTaskById(id);
   }
}

