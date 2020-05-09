package com.deepexi.domain.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UserCreateDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String password;

    @ApiModelProperty(value = "角色集合")
    private List<Integer> roleIds;

}
