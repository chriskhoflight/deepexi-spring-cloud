package com.deepexi.service;


import com.deepexi.repo.*;
import com.deepexi.service.entity.Permission;
import com.deepexi.service.entity.Role;
import com.deepexi.service.entity.User;
import com.deepexi.service.manager.PermissionManager;
import com.deepexi.service.manager.PermissionV2Manager;
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
    private PermissionRepository permissionRepository;


    @Autowired
    private PermissionManager permissionManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PermissionV2Manager permissionV2Manager;


    public User buildUser(Long userId){
        User user = new User(userId,userRepository,roleManager,userRoleRepository);
        return user;
    }

    public Role buildRole(String id){
        return new Role(id,roleRepository,rolePermissionRepository,permissionManager,permissionV2Manager);
    }


    public Permission buildPermission(String id) {
        return new Permission(id,permissionRepository);
    }
}
