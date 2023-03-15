package com.example.projectmanager.controller;

import com.example.projectmanager.dto.request.TaskUpdateDto;
import com.example.projectmanager.entity.Task;
import com.example.projectmanager.entity.enums.TaskStatus;
import com.example.projectmanager.security.Authentication;
import com.example.projectmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @PreAuthorize("hasAnyAuthority('admin','simple_user')")
    @PostMapping
    public Task createTask(@RequestBody Task task) {

        return taskService.createTask(task);
    }

    //@PreAuthorize("hasAnyAuthority('admin','simple_user')")
    @GetMapping
    public List<Task> findAllTasks() {

        return taskService.findAllTasks();
    }

    @PreAuthorize("hasAnyAuthority('admin','simple_user')")
    @PutMapping("/{id}")
    public void changeTaskStatus(@PathVariable Long id, TaskStatus status) {

        taskService.changeStatusTask(id, status);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping
    public Task updateTask(@PathVariable Long id, @RequestBody TaskUpdateDto dto) {

        return taskService.updateTask(id, dto);
    }

    @PreAuthorize("hasAnyAuthority('admin','simple_user')")
    @DeleteMapping
    public void deleteTask(@RequestAttribute Authentication authentication, Task task) {

        taskService.deleteTask(authentication, task);
    }

}

