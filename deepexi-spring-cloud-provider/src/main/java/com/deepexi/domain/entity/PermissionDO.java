package com.deepexi.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@TableName("permission")
public class PermissionDO {
    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private String url;


}
