package com.kieran.teamops.controller;

import com.kieran.teamops.dto.CreateProjectRequest;
import com.kieran.teamops.dto.ProjectResponse;
import com.kieran.teamops.dto.UpdateProjectRequest;
import com.kieran.teamops.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    // POST /api/projects
    @PostMapping
    public ProjectResponse createProject(@Valid @RequestBody CreateProjectRequest request) {
        return projectService.create(request);
    }

    // GET /api/projects
    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAll();
    }

    // GET /api/projects/{id}
    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable Long id) {
        return projectService.getById(id);
    }

    @PutMapping("/{id}")
    public ProjectResponse updateProject(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProjectRequest request) {
        return projectService.update(id, request);
    }


    // DELETE /api/projects/{id}
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.delete(id);
    }
}

