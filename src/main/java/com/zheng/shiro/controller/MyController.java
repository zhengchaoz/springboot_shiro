package com.zheng.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 郑超
 * @create 2021/5/13
 */
@Controller
public class MyController {

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "你好，郑超！");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginAuth")
    public String loginAuth(String username, String password, Model model) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            // 执行登录方法，调用了UserRealm.doGetAuthenticationInfo()方法
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
    }

    @RequestMapping("/unAccount")
    @ResponseBody
    public String unAccount(){
        return "未经授权无法访问此页面！";
    }
}
