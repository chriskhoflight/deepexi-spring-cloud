package com.deepexi.controller;


import com.deepexi.domain.dto.RoleCreateDTO;
import com.deepexi.domain.entity.RoleDO;
import com.deepexi.domain.vo.Pagination;
import com.deepexi.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "角色管理")
@Payload
@Validated
public class RoleController {
    @Autowired
    private RoleService service;


    @ApiOperation("创建角色")
    @PostMapping
    public String create(@RequestBody @Valid RoleCreateDTO dto){
        return service.create(dto);
    }

    @ApiOperation("更新角色")
    @PutMapping
    public void update(){

    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{roleId}")
    public void delete(@PathVariable String id){
        service.remove(id);

    }

    @ApiOperation("获取详情")
    @GetMapping
    public Pagination<RoleDO> listPage(){
        return new Pagination<>();
    }

    @ApiOperation("分配权限")
    @PutMapping
    public void assignPermissions(){

    }

}
