package com.deepexi.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@TableName("role")
@ToString
public class RoleDO {
    @TableId(type = IdType.UUID)
    private String id;

    private String code;

    private String name;

    private Boolean global;

    private String description;

}
