package com.deepexi.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String password;


}
