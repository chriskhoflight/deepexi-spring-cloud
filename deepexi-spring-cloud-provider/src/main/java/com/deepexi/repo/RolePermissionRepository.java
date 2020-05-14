package com.deepexi.repo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.domain.entity.RolePermissionDO;
import com.deepexi.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePermissionRepository {

    @Autowired
    private RolePermissionMapper mapper;

    public List<RolePermissionDO> selectListByRoleId(String roleId) {
        QueryWrapper<RolePermissionDO> queryWrapper = toRoleWrapper(roleId);
        return mapper.selectList(queryWrapper);
    }

    public void deletePermission(String roleId) {
        QueryWrapper<RolePermissionDO> queryWrapper = toRoleWrapper(roleId);
        mapper.delete(queryWrapper);
    }

    private QueryWrapper<RolePermissionDO> toRoleWrapper(String roleId) {
        QueryWrapper<RolePermissionDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(RolePermissionDO::getRoleId,roleId);
        return queryWrapper;
    }
}
