package com.example.projectmanager.entity;

import com.example.projectmanager.entity.enums.TaskStatus;
import com.example.projectmanager.entity.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subproject_id", referencedColumnName = "id")
    private SubProject subProject;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "date_change_status")
    private LocalDateTime dateChangeStatus;

}
