package com.deepexi.repo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepexi.domain.entity.RoleDO;
import com.deepexi.mapper.RoleMapper;
import com.deepexi.service.manager.PermissionManager;
import com.deepexi.service.manager.RoleManager;
import org.apache.commons.lang3.StringUtils;
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

    public Optional<RoleDO> selectById(String id) {
        return Optional.ofNullable(mapper.selectById(id));
    }

    public int updateById(RoleDO entity) {
        return mapper.updateById(entity);
    }

    public void delete(String id) {
        this.mapper.deleteById(id);
    }

    public Page<RoleDO> selectPage(RoleManager.Query query) {
        Page<RoleDO> page = new Page<>(query.getIndex(),query.getSize());
        QueryWrapper<RoleDO> wrapper = toWrapper(query);
        mapper.selectPage(page,wrapper);
        return page;
    }

    private QueryWrapper<RoleDO> toWrapper(RoleManager.Query query) {
        QueryWrapper<RoleDO> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(StringUtils.isNotBlank(query.getCode()),RoleDO::getCode,query.getCode())
                .like(StringUtils.isNotBlank(query.getName()),RoleDO::getName,query.getName())
                .and(role -> role.eq(RoleDO::getGlobal,true));
        return wrapper;
    }
}
