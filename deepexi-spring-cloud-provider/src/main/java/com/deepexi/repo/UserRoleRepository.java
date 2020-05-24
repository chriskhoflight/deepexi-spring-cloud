package com.deepexi.repo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.domain.entity.UserRoleDO;
import com.deepexi.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRoleRepository {
    @Autowired
    private UserRoleMapper mapper;
    public List<UserRoleDO> selectListByUserId(Long id) {
        return this.mapper.selectList(toUserWrapper(id));
    }

    private Wrapper<UserRoleDO> toUserWrapper(Long id) {
        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(UserRoleDO::getUserId,id);
        return queryWrapper;
    }
}
