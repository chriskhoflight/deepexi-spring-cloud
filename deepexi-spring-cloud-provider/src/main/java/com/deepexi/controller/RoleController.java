package com.deepexi.controller;


import com.deepexi.domain.dto.RoleCreateDTO;
import com.deepexi.domain.dto.RoleUpdateDTO;
import com.deepexi.domain.query.RoleQuery;
import com.deepexi.domain.vo.Pagination;
import com.deepexi.domain.vo.RoleVO;
import com.deepexi.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "角色管理")
@RequestMapping("/test/roles")
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
    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody @Valid RoleUpdateDTO dto){
        service.update(id,dto);

    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);

    }

    @ApiOperation("获取详情")
    @GetMapping("/{id}")
    public RoleVO detail(@PathVariable("id") String id){
        return service.detail(id);
    }

    @ApiOperation("获取列表")
    @GetMapping
    public Pagination<RoleVO> listPage(RoleQuery query){
        return service.listPage(query);
    }

    @ApiOperation("分配权限")
    @PutMapping
    public void assignPermissions(){

    }

}
