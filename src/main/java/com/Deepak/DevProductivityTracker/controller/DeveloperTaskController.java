package com.Deepak.DevProductivityTracker.controller;

import com.Deepak.DevProductivityTracker.entity.DeveloperTask;
import com.Deepak.DevProductivityTracker.repo.DeveloperTaskRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class DeveloperTaskController {

    private final DeveloperTaskRepo repository;

    public DeveloperTaskController(DeveloperTaskRepo repository){
        this.repository = repository;
    }

    // Create task
    @PostMapping
    public DeveloperTask createTask(@RequestBody DeveloperTask task){
        return repository.save(task);
    }

    // Get all task
    @GetMapping
    public List<DeveloperTask> getAllTasks(){
        return repository.findAll();
    }

    // Get a task by id
    @GetMapping("/{id}")
    public DeveloperTask getTaskById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found with id : "+id)
        );
    }
    // Update task
    @PutMapping("/{id}")
    public DeveloperTask updateTask(@PathVariable Long id ,@RequestBody DeveloperTask updatedTask){
        return repository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setTaskDescription(updatedTask.getTaskDescription());
                    task.setStatus(updatedTask.getStatus());
                    return repository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id : "+ id));
    }

    // Delete task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        repository.deleteById(id);
        return "Task deleted with id : "+id;
    }

}
