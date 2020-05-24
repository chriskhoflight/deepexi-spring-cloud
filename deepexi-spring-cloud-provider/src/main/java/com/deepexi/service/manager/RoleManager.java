package com.deepexi.service.manager;


import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.query.PaginationRequest;
import com.deepexi.domain.vo.Pagination;
import com.deepexi.exception.DataNotFoundException;
import com.deepexi.exception.DataRepetitionException;
import com.deepexi.repo.RoleRepository;
import com.deepexi.service.Builder;
import com.deepexi.service.entity.Role;
import com.netflix.discovery.converters.Auto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.deepexi.util.ConverterUtils.convert;

@Component
public class RoleManager {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private Builder builder;

    public Role create(RoleManager.Create model){
        RoleDO entity = convert(model,RoleDO.class);
        //判断是否有新增的权限
        //checkPermission();
        //判断是否存在
        if (roleRepository.exist()){
            throw new DataRepetitionException("已存在同名角色,无法创建");
        }
        String id = roleRepository.insert(entity);
        return builder.buildRole(id);
    }

    public Role get(String id) {
        roleRepository.selectById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("No such role[%s]",id)));

        return builder.buildRole(id);

    }

    public void remove(String id) {
        //判断是否有删除的权限，没有权限则抛出异常
        //根据角色id去查权限列
    }

    public Pagination<Role> listPage(Query query) {
        Pagination<RoleDO> pagination = this.listDOPage(query);
        return new Pagination<>(pagination.getTotal(),pagination.getRows()
        .stream()
        .map(data -> builder.buildRole(data.getId()))
        .collect(Collectors.toList()));
    }

    private Pagination<RoleDO> listDOPage(Query query) {
        return Pagination.from(this.roleRepository.selectPage(query));

    }

    /**
     * 查询用户所拥有的角色
     * @param roleIds
     * @return
     */
    public List<Role> selectListByIds(List<String> roleIds) {
        List<RoleDO> roleDOList = roleRepository.selectListByIds(roleIds);
        return roleDOList.stream()
                .map(data -> builder.buildRole(data.getId()))
                .collect(Collectors.toList());
    }


    @Data
    public static class Create{
        private String code;
        private String name;
    }
    @Data
    public static class Update{
        private String name;
    }
    @Data
    public static class Query extends PaginationRequest{
        private String code;
        private String name;
    }
}
