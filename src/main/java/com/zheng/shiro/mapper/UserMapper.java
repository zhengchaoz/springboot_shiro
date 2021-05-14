package com.zheng.shiro.mapper;

import com.zheng.shiro.pojo.User;

/**
 * @author 郑超
 * @create 2021/5/14
 */
public interface UserMapper {

    public User queryOneByName(String name);

}
