package com.deepexi.service.entity;

import com.deepexi.domain.entity.UserRoleDO;
import com.deepexi.domain.vo.Pagination;
import com.deepexi.enums.PermissionCode;
import com.deepexi.exception.DataPermissionException;
import com.deepexi.repo.UserRepository;
import com.deepexi.repo.UserRoleRepository;
import com.deepexi.service.Builder;
import com.deepexi.service.manager.RoleManager;
import com.deepexi.util.CustomizePermission;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.deepexi.util.ConverterUtils.convert;

public class User extends DomainEntity<Long, UserRepository>{

    private RoleManager roleManager;

    private UserRoleRepository userRoleRepository;

    @Autowired
    private Builder builder;

    public User(Long id,UserRepository repository,RoleManager roleManager,UserRoleRepository userRoleRepository){
        super(id,repository);
        this.roleManager = roleManager;
        this.userRoleRepository = userRoleRepository;
    }

    //创建角色
    public Role createRole(RoleManager.Create create){
        checkPermission(PermissionCode.CREATE);
        return roleManager.create(create);
    }

    private void checkPermission(PermissionCode permissionCode) {
        this.permissionCheck(permissionCode.getCode());
    }

    private void permissionCheck(String permissionCode){
        if (CollectionUtils.isEmpty(this.getRoles())){
            throw new DataPermissionException("There is no permission to do this.");
        }
        for(Role role : this.getRoles()){
            for (CustomizePermission permission : buildRolePermission(role.permissionCodes())){
                if (permission.implies(toCheckPermission(permissionCode))){
                    return;
                }
            }
        }
    }

    private CustomizePermission toCheckPermission(String permissionCode) {
        return new CustomizePermission(permissionCode);
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

    /**
     * 根据当前用户查询角色 id 列表
     * @return
     */
    public List<String> getRoleId(){
        return userRoleRepository.selectListByUserId(this.getId())
                .stream()
                .map(UserRoleDO::getRoleId)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     *
     * @return
     */
    public List<Role> getRoles(){
        List<String> roleIds = this.getRoleId();
        if (CollectionUtils.isEmpty(roleIds)){
            return Collections.EMPTY_LIST;
        }
        return roleManager.selectListByIds(roleIds);
    }

    private List<CustomizePermission> buildRolePermission(List<String> permissionCodes){
        return permissionCodes.stream()
                .map(CustomizePermission::new)
                .collect(Collectors.toList());
    }


    @Data
    public static class RoleQuery{
        private String code;
        private String name;
    }
}
