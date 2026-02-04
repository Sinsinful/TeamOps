package com.kieran.teamops.service;

import com.kieran.teamops.dto.CreateProjectRequest;
import com.kieran.teamops.dto.ProjectResponse;
import com.kieran.teamops.exception.NotFoundException;
import com.kieran.teamops.model.Project;
import com.kieran.teamops.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public ProjectResponse create(CreateProjectRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());

        Project savedProject = projectRepository.save(project);

        ProjectResponse response = new ProjectResponse();
        response.setId(savedProject.getId());
        response.setName(savedProject.getName());
        response.setDescription(savedProject.getDescription());

        return response;
    }

    public List<ProjectResponse> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProjectResponse getById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found with id " + id));

        return toResponse(project);
    }

    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found with id " + id));

        projectRepository.deleteById(project.getId());
    }

    private ProjectResponse toResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        return response;
    }


}
