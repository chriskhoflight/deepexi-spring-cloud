package com.deepexi.service.entity;

import com.deepexi.repo.UserAndRoleRepository;

public class UserAndRole {

    private UserAndRoleRepository userAndRoleRepository;

    public void removeUserAndRole(String roleId){
        userAndRoleRepository.removeById(roleId);
    }
}
