package kz.orynbek.restApiFinalProject.service;

import kz.orynbek.restApiFinalProject.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTaskById(Long id);
}
