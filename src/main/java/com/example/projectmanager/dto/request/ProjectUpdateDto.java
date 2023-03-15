package com.example.projectmanager.dto.request;

import com.example.projectmanager.entity.SubProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectUpdateDto {

    private String name;

    private List<SubProject> subProjectList;
}
