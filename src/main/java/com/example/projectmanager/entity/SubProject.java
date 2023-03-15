package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subprojects")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subProject", fetch = FetchType.EAGER)
    private List<Task> task;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

}
