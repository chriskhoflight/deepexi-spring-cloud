package com.deepexi.service;


import com.deepexi.domain.vo.PermissionVO;
import com.deepexi.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private UserManager userManager;

    public List<PermissionVO> list(List<String> roleIds){
        return new ArrayList<PermissionVO>();
    }
}
