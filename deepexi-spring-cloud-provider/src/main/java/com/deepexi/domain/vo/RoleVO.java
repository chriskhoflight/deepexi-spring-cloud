package com.deepexi.domain.vo;


import lombok.Data;

import java.util.List;

@Data
public class RoleVO {
    private String id;
    private String code;
    private String name;
    private String description;
    private List<PermissionVO> permissions;
}
