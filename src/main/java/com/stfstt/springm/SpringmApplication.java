package com.stfstt.springm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * //导入SPRING配置文件
 *
 * @ImportResource(locations = {"classpath:spring01.xml"})
 */

@SpringBootApplication
@MapperScan("com.stfstt.springm.mapper")
public class SpringmApplication {

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SpringmApplication.class, args);
    }

    @Bean
    public ViewResolver MyViewResolver() {
        return new MyViewResolver();
    }

    class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
