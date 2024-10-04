package kz.orynbek.restApiFinalProject.service.impl;

import kz.orynbek.restApiFinalProject.entities.Task;
import kz.orynbek.restApiFinalProject.repositories.TaskRepository;
import kz.orynbek.restApiFinalProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findAllById(id);
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
