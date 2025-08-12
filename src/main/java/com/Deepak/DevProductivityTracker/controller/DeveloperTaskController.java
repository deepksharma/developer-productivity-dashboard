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

    @GetMapping
    public List<DeveloperTask> getAllTasks(){
        return repository.findAll();
    }
    @PostMapping
    public DeveloperTask createTask(@RequestBody DeveloperTask task){
        return repository.save(task);
    }
}
