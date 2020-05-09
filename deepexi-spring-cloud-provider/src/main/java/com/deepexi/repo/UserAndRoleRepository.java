package com.deepexi.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.mapper.UserAndRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAndRoleRepository {
    @Autowired
    private UserAndRoleMapper userAndRoleMapper;
    public void removeById(String roleId) {
        QueryWrapper<UserAndRoleDO>
    }
}
