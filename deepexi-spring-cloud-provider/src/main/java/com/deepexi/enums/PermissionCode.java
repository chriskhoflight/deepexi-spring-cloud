package com.deepexi.enums;

public enum PermissionCode {


    ASSIGN("role:assign", "分配角色"),
    CREATE("rode:create","创建角色"),
    UPDATE("role:update","更新角色"),
    VIEW("role:view","查看角色"),
    DELETE("rode:delete","删除角色"),
    API_VIEW("api:view","接口信息");


    private String code;

    private String name;


    PermissionCode(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
}
