package com.stfstt.springm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//完全掌控SpringMVC--EnableWebMvc  不建议使用
//@EnableWebMvc
@Configuration
public class MySpringMvcConfiguer implements WebMvcConfigurer {
    //增加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/iloveyoustt").setViewName("provider/success");
    }
}
