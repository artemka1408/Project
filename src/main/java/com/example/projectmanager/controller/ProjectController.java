package com.example.projectmanager.controller;


import com.example.projectmanager.dto.request.ProjectUpdateDto;
import com.example.projectmanager.entity.Project;
import com.example.projectmanager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Project createProject(@RequestBody Project project) {

        return projectService.createProject(project);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SIMPLE_USER')")
    @GetMapping
    public List<Project> findAllProjects() {

        return projectService.findAllProjects();
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, ProjectUpdateDto dto) {

        return projectService.updateProject(id, dto);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public void delete(Long id) {

       projectService.delete(id);
    }
}
