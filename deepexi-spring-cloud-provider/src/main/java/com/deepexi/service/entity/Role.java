package com.deepexi.service.entity;

import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.entity.RolePermissionDO;
import com.deepexi.exception.DataPermissionException;
import com.deepexi.repo.RolePermissionRepository;
import com.deepexi.repo.RoleRepository;
import com.deepexi.service.manager.PermissionManager;

import java.util.List;

public class Role extends DomainEntity<String, RoleRepository> {

    private RolePermissionRepository rolePermissionRepository;
    private PermissionManager permissionManager;

    public Role(String id,RoleRepository roleRepository,RolePermissionRepository rolePermissionRepository,PermissionManager permissionManager){
        super(id,roleRepository);
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionManager = permissionManager;
    }

    public void delete(){
    }

    public RoleDO data() {
        return this.getRepo().selectById(this.getId());
    }
    public void checkPerssion(){
        //根据角色去查询权限列表，看是否有相应的权限
        //有则可以进行操作，无则抛出异常
        List<RolePermissionDO> permissionDOS = permissionCodes();
        //查询出来的列表和枚举类对比
        throw new DataPermissionException("你没有权限进行此操作");
    }

    public List<RolePermissionDO> permissionCodes(){
        return rolePermissionRepository.selectByRole();
    }


}
