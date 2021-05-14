package com.zheng.shiro;

import com.zheng.shiro.mapper.UserMapper;
import com.zheng.shiro.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User root = userMapper.queryOneByName("root");
        System.out.println(root);
    }

}
