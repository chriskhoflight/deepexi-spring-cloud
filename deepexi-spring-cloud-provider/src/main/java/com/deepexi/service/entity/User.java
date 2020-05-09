package com.deepexi.service.entity;

import com.deepexi.repo.UserRepository;
import com.deepexi.service.Builder;
import com.deepexi.service.manager.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;

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
        return roleManager.create(create);
    }
    //删除角色
    public void removeRole(String id){
        //return roleManager.remove(id);
    }

    //查询角色
    public Role getRole(String roleId){
        return roleManager.get(roleId);
    }

    public Long createUser(){
        //根据当前用户角色去查询权限
        return 1L;
    }

    public UserAndRole getUserAndRole(){
        return new UserAndRole();
    }
}
