package com.deepexi.service.entity;

import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.entity.RolePermissionDO;
import com.deepexi.exception.DataNotFoundException;
import com.deepexi.exception.DataPermissionException;
import com.deepexi.repo.RolePermissionRepository;
import com.deepexi.repo.RoleRepository;
import com.deepexi.service.manager.PermissionManager;
import com.deepexi.service.manager.PermissionV2Manager;
import com.deepexi.service.manager.RoleManager;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.deepexi.util.ConverterUtils.convert;

public class Role extends DomainEntity<String, RoleRepository> {

    private RolePermissionRepository rolePermissionRepository;
    private PermissionManager permissionManager;
    private PermissionV2Manager permissionV2Manager;

    public Role(String id, RoleRepository roleRepository, RolePermissionRepository rolePermissionRepository, PermissionManager permissionManager, PermissionV2Manager permissionV2Manager){
        super(id,roleRepository);
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionManager = permissionManager;
        this.permissionV2Manager = permissionV2Manager;
    }

    //删除角色
    public void delete(){
        //检查是否有默认权限
        checkGlobalRole();
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
        checkGlobalRole();
        RoleDO entity = convert(update,RoleDO.class);
        entity.setId(this.getId());
        this.getRepo().updateById(entity);
    }

    //分配权限
    public void assignPermission(List<String> permissionCodes){
        checkGlobalRole();
        checkExistPermissionCode(permissionCodes);
        this.rolePermissionRepository.deletePermission(this.getId());
        permissionCodes.stream().map(code ->{
            RolePermissionDO rolePermissionDO = new RolePermissionDO();
            rolePermissionDO.setRoleId(this.getId());
            rolePermissionDO.setPermissionCode(code);
            return rolePermissionDO;
        }).forEach(rolePermissionRepository::insert);
    }

    private void checkExistPermissionCode(List<String> permissionCodes) {
        for (String permissionCode : permissionCodes){
            permissionManager.get(permissionCode)
                    .orElseThrow(() -> new DataNotFoundException("权限码不存在"));
        }
    }

    private void checkGlobalRole() {
        RoleDO roleDO = this.data();
        if (Objects.isNull(roleDO)){
            throw new DataNotFoundException("角色不存在");
        }
        if (roleDO.getGlobal()){
            throw new DataPermissionException("默认角色无法操作");
        }
    }

    /**
     * V1 版本 查询权限码
     * @return
     */
    public List<String> permissionCodes(){
        return rolePermissionRepository.selectListByRoleId(this.getId())
                .stream()
                .map(RolePermissionDO::getPermissionCode)
                .collect(Collectors.toList());
    }

    /**
     * V2 版本查询权限列表
     */
    public List<String> getPermissionIds(){
        return rolePermissionRepository.selectListByRoleId(this.getId())
                .stream()
                .map(RolePermissionDO::getPermissionCode)
                .collect(Collectors.toList());
    }

    public List<Permission> getByPermissionIds(){
        List<String> permissionIds = this.getPermissionIds();
        if (CollectionUtils.isEmpty(permissionIds)){
            return Collections.EMPTY_LIST;
        }
        return permissionV2Manager.selectByPermissionIds(permissionIds);
    }




}
