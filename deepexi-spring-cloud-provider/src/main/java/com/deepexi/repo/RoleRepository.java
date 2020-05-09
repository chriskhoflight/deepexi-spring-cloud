package com.deepexi.repo;


import com.deepexi.domain.entity.RoleDO;
import com.deepexi.mapper.RoleMapper;
import com.deepexi.service.manager.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleRepository {
    @Autowired
    private RoleMapper mapper;

//    public Optional<RoleDO> selectById(String roleId) {
//        return Optional.ofNullable(mapper.selectById(roleId));
//    }

    //判断该角色是否已经存在
    public boolean exist() {
        return false;
    }

    public String insert(RoleDO entity) {
        mapper.insert(entity);
        return entity.getId();
    }

    public RoleDO selectById(String id) {
        return (RoleDO) mapper.selectById(id);
    }
}
