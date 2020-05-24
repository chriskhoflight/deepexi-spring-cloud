package com.deepexi.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserRoleDO {

    @TableId(type = IdType.UUID)
    private String id;
    private Integer userId;
    private String roleId;
}
