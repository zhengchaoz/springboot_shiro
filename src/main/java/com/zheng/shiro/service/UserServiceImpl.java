package com.zheng.shiro.service;

import com.zheng.shiro.mapper.UserMapper;
import com.zheng.shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑超
 * @create 2021/5/14
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryOneByName(String name) {
        return userMapper.queryOneByName(name);
    }
}
