package com.deepexi.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.domain.entity.PermissionDO;
import com.deepexi.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionRepository {
    @Autowired
    private PermissionMapper mapper;
    public String insert(PermissionDO entity) {
         mapper.insert(entity);
         return entity.getId();
    }


    /**
     * 查询用户权限列表
     * @param permissionIds
     * @return
     */
    public List<PermissionDO> selectByIds(List<String> permissionIds) {
        QueryWrapper<PermissionDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(PermissionDO::getId,permissionIds);
        return mapper.selectList(queryWrapper);
    }
}
