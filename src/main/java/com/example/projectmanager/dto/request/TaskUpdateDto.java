package com.example.projectmanager.dto.request;

import com.example.projectmanager.entity.enums.TaskStatus;
import com.example.projectmanager.entity.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateDto {

     private String name;

     private TaskType type;

     private TaskStatus status;

     private LocalDateTime created;

     private LocalDateTime dateChangeStatus;

     private String description;

     private Long userId;
 }
