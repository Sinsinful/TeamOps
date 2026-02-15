package com.kieran.teamops.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProjectRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public CreateProjectRequest() {}

    public CreateProjectRequest(String name, String description){
        this.name = name;
        this.description = description;
    }

}
