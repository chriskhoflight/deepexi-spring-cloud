package com.deepexi.service.entity;

import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.entity.RolePermissionDO;
import com.deepexi.exception.DataPermissionException;
import com.deepexi.repo.RolePermissionRepository;
import com.deepexi.repo.RoleRepository;
import com.deepexi.service.manager.PermissionManager;
import com.deepexi.service.manager.RoleManager;

import java.util.List;
import java.util.stream.Collectors;

import static com.deepexi.util.ConverterUtils.convert;

public class Role extends DomainEntity<String, RoleRepository> {

    private RolePermissionRepository rolePermissionRepository;
    private PermissionManager permissionManager;

    public Role(String id,RoleRepository roleRepository,RolePermissionRepository rolePermissionRepository,PermissionManager permissionManager){
        super(id,roleRepository);
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionManager = permissionManager;
    }

    //删除角色
    public void delete(){
        //检查是否有默认权限
        //checkGlobalRole();
        this.getRepo().delete(this.getId());
        this.rolePermissionRepository.deletePermission(this.getId());
    }

    public RoleDO data() {
        return this.getRepo().selectById(this.getId()).get();
    }
    public void checkPerssion(){
        //根据角色去查询权限列表，看是否有相应的权限
        //有则可以进行操作，无则抛出异常
        //List<RolePermissionDO> permissionDOS = permissionCodes();
        //查询出来的列表和枚举类对比
        throw new DataPermissionException("你没有权限进行此操作");
    }

    //更新角色
    public void update(RoleManager.Update update){
        //检查权限
        //checkGlobalRole();
        RoleDO entity = convert(update,RoleDO.class);
        entity.setId(this.getId());
        this.getRepo().updateById(entity);

    }

    public List<String> permissionCodes(){
        return rolePermissionRepository.selectListByRoleId(this.getId())
                .stream()
                .map(RolePermissionDO::getPermissionCode)
                .collect(Collectors.toList());
    }


}
