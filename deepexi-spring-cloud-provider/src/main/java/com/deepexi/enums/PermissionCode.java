package com.deepexi.enums;

public enum PermissionCode {


    ASSIGN("role:assign", "分配角色"),
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
