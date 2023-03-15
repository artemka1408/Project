package com.example.projectmanager.service;

import com.example.projectmanager.dto.request.ProjectUpdateDto;
import com.example.projectmanager.entity.Project;
import com.example.projectmanager.security.Authentication;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> findAllProjects();

    Project updateProject(Long id, ProjectUpdateDto dto);

    void delete(Long id);

}
