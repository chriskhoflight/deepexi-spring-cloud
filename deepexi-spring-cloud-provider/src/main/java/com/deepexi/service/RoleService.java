package com.deepexi.service;


import com.deepexi.domain.dto.RoleCreateDTO;
import com.deepexi.domain.dto.RoleUpdateDTO;
import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.query.RoleQuery;
import com.deepexi.domain.vo.Pagination;
import com.deepexi.domain.vo.RoleVO;
import com.deepexi.service.entity.Role;
import com.deepexi.service.entity.User;
import com.deepexi.service.manager.RoleManager;
import com.deepexi.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;
import static com.deepexi.pojo.converter.utils.ConverterUtils.convertAll;

@Service
public class RoleService {

    @Autowired
    private UserManager userManager;
    public String create(RoleCreateDTO dto) {
        return userManager
                .current()
                .createRole(convert(dto, RoleManager.Create.class))
                .getId();
    }

    public void update(String id, RoleUpdateDTO dto) {
        userManager.current()
                .getRole(id)
                .update(convert(dto,RoleManager.Update.class));
    }

    public RoleVO detail(String id) {
        return convert(userManager.current().getRole(id),RoleVO.class);
    }

    public Pagination<RoleVO> listPage(RoleQuery query) {
        Pagination<Role> page = userManager.current().listRolePage(convert(query, User.RoleQuery.class));
        return new Pagination<>(page.getTotal(),convertAll(page.getRows(),RoleVO.class));
    }

    public void delete(String id) {
        userManager.current()
                .getRole(id)
                .delete();
    }

    public void assignPermission(String id, List<String> permissionCodes) {
        userManager.current()
                .getRole(id)
                .assignPermission(permissionCodes);
    }
}
