package com.kieran.teamops.controller;

import com.kieran.teamops.dto.CreateProjectRequest;
import com.kieran.teamops.dto.ProjectResponse;
import com.kieran.teamops.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public ProjectResponse createProject(@RequestBody CreateProjectRequest request) {
        return projectService.create(request);
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAll();
    }


}
