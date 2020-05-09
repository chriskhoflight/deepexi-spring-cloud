package com.deepexi.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role_permission")
public class RolePermissionDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String roleId;

    private String permissionCode;
}
