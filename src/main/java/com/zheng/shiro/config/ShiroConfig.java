package com.zheng.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 郑超
 * @create 2021/5/13
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        // 添加shiro的内置过滤器
        /*
         * anon：无需认证即可访问
         * authc：认证了开可以访问
         * user：必须拥有 记住我 功能才能使用
         * perms：拥有对某个资源的权限才能访问
         * role: 拥有某个角色权限才能访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();
        // 授权
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");
        filterMap.put("/user/*", "authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        // 没有权限就跳转登录界面
        factoryBean.setLoginUrl("/login");
        // 未授权就跳转的页面
        factoryBean.setUnauthorizedUrl("/unAccount");
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
