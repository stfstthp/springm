package com.stfstt.springm.config;

import com.stfstt.springm.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConfig {

    /**
     * 返回值就是注入容器中的组件对象
     * 方法名就是这个组件的ID值
     *
     * @return
     */
    @Bean
    public EmpService empService2() {
        System.out.println("EmpService 组件注入成功");
        return new EmpService();
    }
}
