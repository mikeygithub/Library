package com.mikey.eas.Config;

//import cn.mikey.eas.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/10/23 11:29
 * @Version 1.0
 */
@Configuration
public class EasWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**","/templates/**","/common/**","/static/img/**").
                addResourceLocations("classpath:/static/","classpath:/templates/","classpath:/static/common","classpath:/static/img/");
    }
}
