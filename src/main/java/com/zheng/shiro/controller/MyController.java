package com.zheng.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
