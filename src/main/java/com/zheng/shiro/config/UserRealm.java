package com.zheng.shiro.config;

import com.zheng.shiro.pojo.User;
import com.zheng.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 郑超
 * @create 2021/5/13
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 认证   
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryOneByName(token.getUsername());
        if (user == null) {// 相当于从数据库中查找用户信息来匹配
            return null;// 没有匹配到就返回null，会出发相应的异常信息
        }
        // 用户认证， 密码， 认证名
        return new SimpleAuthenticationInfo("", user.getPwd(), "");
    }

}
