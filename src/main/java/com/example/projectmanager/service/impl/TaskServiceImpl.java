package com.example.projectmanager.service.impl;

import com.example.projectmanager.dto.request.TaskUpdateDto;
import com.example.projectmanager.entity.Task;
import com.example.projectmanager.entity.enums.Role;
import com.example.projectmanager.entity.enums.TaskStatus;
import com.example.projectmanager.exception.ForbiddenException;
import com.example.projectmanager.exception.TaskNotFoundException;
import com.example.projectmanager.repository.TaskRepository;
import com.example.projectmanager.security.Authentication;
import com.example.projectmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Authentication authentication, Task task) {

        if (authentication.hasRole(Role.SIMPLE_USER)) {
            if (!authentication.getUserId().equals(task.getUserId())) {
                throw new ForbiddenException("Обычный пользователь может удалять только свои задания");
            }

            taskRepository.delete(task);
        }

        taskRepository.delete(task);
    }

    public void changeStatusTask(Long taskId, TaskStatus status) {

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Задача с id " + taskId + " не найдена!"));

        task.setStatus(status);
        task.setDateChangeStatus(LocalDateTime.now());

        taskRepository.save(task);
    }

    public List<Task> findAllTasks() {

        return taskRepository.findAll();
    }

    public Task updateTask(Long id, TaskUpdateDto dto) {

        Task task = Task.builder()
                .id(id)
                .name(dto.getName())
                .type(dto.getType())
                .status(dto.getStatus())
                .created(dto.getCreated())
                .dateChangeStatus(dto.getDateChangeStatus())
                .description(dto.getDescription())
                .userId(dto.getUserId())
                .build();

        return taskRepository.save(task);
    }

}
