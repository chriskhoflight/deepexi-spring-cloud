package com.deepexi.config;

import com.deepexi.service.UserService;
import com.deepexi.service.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //  授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 认证登录方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String username = usernamePasswordToken.getUsername();
//        User user = userService.findByUserName(username);
//        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
        return null;
    }
}
