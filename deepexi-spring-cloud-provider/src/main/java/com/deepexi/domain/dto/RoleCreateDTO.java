package com.deepexi.domain.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleCreateDTO {
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    private String description;

}
