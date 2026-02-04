package com.kieran.teamops.repository;

import com.kieran.teamops.model.Project;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProjectRepository {

    private final Map<Long, Project> projects = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Project save(Project project) {
        if (project.getId() == null) {
            project.setId(idGenerator.getAndIncrement());
        }
        projects.put(project.getId(), project);
        return project;
    }

    public Optional<Project> findById (Long id){
        return Optional.ofNullable(projects.get(id));
    }

    public List<Project> findAll() {
        return new ArrayList<>(projects.values());
    }

    public void deleteById(Long id) {
        projects.remove(id);
    }
}