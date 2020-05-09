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

    public List<RolePermissionDO> selectByRole() {
        return mapper.selectList(new QueryWrapper());
    }
}
