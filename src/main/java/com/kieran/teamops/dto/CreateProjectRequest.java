package com.kieran.teamops.dto;

import lombok.Data;

@Data
public class CreateProjectRequest {
    private String name;
    private String description;

    public CreateProjectRequest() {}

    public CreateProjectRequest(String name, String description){
        this.name = name;
        this.description = description;
    }

}
