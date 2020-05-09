package com.deepexi.domain.vo;


import com.deepexi.enums.PermissionCode;
import lombok.Data;

@Data
public class PermissionVO {

    private String id;
    private PermissionCode code;
}
