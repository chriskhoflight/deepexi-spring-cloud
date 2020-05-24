package com.deepexi.service.manager;


import com.deepexi.domain.entity.PermissionDO;
import com.deepexi.repo.PermissionRepository;
import com.deepexi.service.Builder;
import com.deepexi.service.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionV2Manager {

    @Autowired
    private PermissionRepository repository;

    @Autowired
    private Builder builder;

    public Permission create(){
        PermissionDO permissionDO = new PermissionDO();
        String id = repository.insert(permissionDO);
        return builder.buildPermission(id);
    }


    public List<Permission> selectByPermissionIds(List<String> permissionIds) {
        List<PermissionDO> permissionDOList = repository.selectByIds(permissionIds);
        return permissionDOList.stream()
                .map(data -> builder.buildPermission(data.getId()))
                .collect(Collectors.toList());
    }
}
