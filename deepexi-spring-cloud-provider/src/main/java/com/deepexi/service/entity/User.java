package com.deepexi.service.entity;

import com.deepexi.domain.vo.Pagination;
import com.deepexi.repo.UserRepository;
import com.deepexi.service.Builder;
import com.deepexi.service.manager.RoleManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import static com.deepexi.util.ConverterUtils.convert;

public class User extends DomainEntity<Long, UserRepository>{

    private RoleManager roleManager;

    @Autowired
    private Builder builder;

    public User(Long id,UserRepository repository,RoleManager roleManager){
        super(id,repository);
        this.roleManager = roleManager;
    }

    //创建角色
    public Role createRole(RoleManager.Create create){
        //checkPermission();
        return roleManager.create(create);
    }
    //删除角色
    public void deleteRole(String id){
        //checkPermission()
        this.getRole(id).delete();
    }
    //查询角色
    public Role getRole(String roleId){
        return roleManager.get(roleId);
    }

    public Long createUser(){
        //根据当前用户角色去查询权限
        return 1L;
    }
    //查询角色列表
    public Pagination<Role> listRolePage(RoleQuery query){
        //checkPermission()
        return this.roleManager.listPage(doConvert(query));
    }

    private RoleManager.Query doConvert(RoleQuery query) {
        RoleManager.Query q = convert(query,RoleManager.Query.class);
        return q;
    }

    @Data
    public static class RoleQuery{
        private String code;
        private String name;
    }
}
