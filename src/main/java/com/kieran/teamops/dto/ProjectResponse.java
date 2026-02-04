package com.kieran.teamops.dto;

import lombok.Data;

@Data
public class ProjectResponse {

    private Long id;
    private String name;
    private String description;

    public ProjectResponse() {};

    public ProjectResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


}
