package com.example.projectmanager.service;

import com.example.projectmanager.dto.request.TaskUpdateDto;
import com.example.projectmanager.entity.Task;
import com.example.projectmanager.entity.enums.TaskStatus;
import com.example.projectmanager.security.Authentication;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    void deleteTask(Authentication authentication, Task task);

    void changeStatusTask(Long taskId, TaskStatus status);

    List<Task> findAllTasks();

    Task updateTask(Long id, TaskUpdateDto dto);


}
