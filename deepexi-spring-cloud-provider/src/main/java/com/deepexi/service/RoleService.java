package com.deepexi.service;


import com.deepexi.domain.dto.RoleCreateDTO;
import com.deepexi.service.manager.RoleManager;
import com.deepexi.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

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

    public void remove(String id) {
        return userManager
                .current()
                .getUserAndRole()
                .remove(id);

    }
}
