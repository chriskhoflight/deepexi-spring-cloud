package com.deepexi.converter;


import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.vo.PermissionVO;
import com.deepexi.domain.vo.RoleVO;
import com.deepexi.service.entity.Role;
import com.deepexi.service.manager.PermissionManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Role2RoleVOConverter implements Converter<Role, RoleVO> {
    @Autowired
    private PermissionManager permissionManager;

    @Override
    public RoleVO convert(Role from) {
        RoleVO to = new RoleVO();
        RoleDO data = from.data();
        BeanUtils.copyProperties(data,to);
        List<String> permissionCodes = from.permissionCodes();
        List<PermissionVO> permissions = permissionCodes.stream().map(code ->{
            PermissionVO permissionVO = new PermissionVO();
            permissionVO.setCode(code);
            permissionVO.setName(permissionManager.get(code).orElseGet(PermissionManager.Permission::new).getName());
            return permissionVO;
        }).collect(Collectors.toList());
        to.setPermissions(permissions);

        return to;
    }
}
