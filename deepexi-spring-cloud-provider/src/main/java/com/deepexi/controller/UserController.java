package com.deepexi.controller;


import com.deepexi.domain.dto.UserCreateDTO;
import com.deepexi.domain.dto.UserQueryDTO;
import com.deepexi.domain.vo.UserVO;
import com.deepexi.service.UserService;
import com.deepexi.service.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@Payload
@Validated
@Api(tags = "用户管理")
@RequestMapping("test/user")

public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userService.login(username,password);
    }

    //登出



    @ApiOperation("新增用户")
    @PostMapping
    public Long create(@RequestBody @Valid UserCreateDTO dto,
                       HttpServletRequest httpServletRequest){

        return userService.create(dto);
        //判断当前用户是否有权限
        //有则新增，无则抛出异常
    }

    @ApiOperation("删除用户")
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable long id){
        userService.delete(id);
    }

    @ApiOperation("修改用户")
    @PutMapping("/{id}")
    public void Update(@PathVariable Long id,@RequestBody @Valid UserCreateDTO dto){
        userService.update(dto, id);
    }

    @ApiOperation("查询用户")
    @GetMapping("/{id}")
    public UserVO detail(@PathVariable Long id){
        return userService.getUser(id);
    }

    @ApiOperation("多条件获取用户详细信息")
    @GetMapping
    public List<UserVO> list(@RequestBody @Valid UserQueryDTO dto){
        return userService.list(dto);
    }






}
