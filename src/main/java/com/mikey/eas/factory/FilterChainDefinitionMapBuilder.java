package com.mikey.eas.factory;

import java.util.LinkedHashMap;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/11/3 20:36
 * @Version 1.0
 */
public class FilterChainDefinitionMapBuilder {
    public static LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
//        静态资源文件
        linkedHashMap.put("/static/**","anon");
        linkedHashMap.put("/bower_components/**","anon");
        linkedHashMap.put("/common/**","anon");
        linkedHashMap.put("/css/**","anon");
        linkedHashMap.put("/fonts/**","anon");
        linkedHashMap.put("/img/**","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/misc/**","anon");//匿名即可访问静态资源文件
//        用户登入请求
        linkedHashMap.put("/login","anon");//匿名即可访问
        linkedHashMap.put("/register","anon");
        linkedHashMap.put("/logout","logout");//注销
        linkedHashMap.put("/ui","anon");//匿名即可访问
        linkedHashMap.put("/addAdmin","authc,roles[superadmin]");//需要认证和授权为superadmin
        linkedHashMap.put("/**","authc");//认证FormAuthenticationFilter
//        linkedHashMap.put("/**","MyFormAuthenticationFilter");
        return linkedHashMap;
    }
}
