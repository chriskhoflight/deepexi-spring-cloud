package com.deepexi.service;


import com.deepexi.repo.RolePermissionRepository;
import com.deepexi.repo.RoleRepository;
import com.deepexi.repo.UserRepository;
import com.deepexi.service.entity.Role;
import com.deepexi.service.entity.User;
import com.deepexi.service.manager.PermissionManager;
import com.deepexi.service.manager.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;


    @Autowired
    private PermissionManager permissionManager;

    @Autowired
    private RoleManager roleManager;


    public User buildUser(Long userId){
        User user = new User(userId,userRepository,roleManager);
        return user;
    }

    public Role buildRole(String id){
        return new Role(id,roleRepository,rolePermissionRepository,permissionManager);
    }


}
