package com.zheng.shiro.service;

import com.zheng.shiro.pojo.User;

/**
 * @author 郑超
 * @create 2021/5/14
 */
public interface UserService {

    public User queryOneByName(String name);

}
