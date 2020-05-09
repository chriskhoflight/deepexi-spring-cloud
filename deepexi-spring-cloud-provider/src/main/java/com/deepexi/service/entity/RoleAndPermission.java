package com.deepexi.service.entity;

import com.deepexi.domain.vo.PermissionVO;
import com.deepexi.repo.RoleAndPermissionRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleAndPermission {

    private RoleAndPermissionRepository roleAndPermissionRepository;

    public List<PermissionVO> list(String roleId){
        return new ArrayList<PermissionVO>();
    };
}
