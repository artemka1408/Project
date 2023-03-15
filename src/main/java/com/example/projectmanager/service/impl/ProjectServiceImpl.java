package com.example.projectmanager.service.impl;

import com.example.projectmanager.dto.request.ProjectUpdateDto;
import com.example.projectmanager.entity.Project;
import com.example.projectmanager.entity.enums.Role;
import com.example.projectmanager.exception.ForbiddenException;
import com.example.projectmanager.repository.ProjectRepository;
import com.example.projectmanager.security.Authentication;
import com.example.projectmanager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {

        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAllProjects() {

        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Long id, ProjectUpdateDto dto) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ForbiddenException("Проект не найден!"));

        project.setName(dto.getName());
        project.setSubProjectList(dto.getSubProjectList());

        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {

        projectRepository.deleteById(id);
    }
}
