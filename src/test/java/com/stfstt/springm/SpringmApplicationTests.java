package com.stfstt.springm;

import com.stfstt.springm.bean.Emp;
import com.stfstt.springm.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmApplicationTests {
    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Emp emp;
    @Autowired
    ApplicationContext context;

    @Test
    public void abc() {
//        String o = new String("123");
//        SoftReference<Object> softReference = new SoftReference<>(o);
//        o = null;
//        System.gc();
//        System.err.println(o);
//        System.err.println( softReference.get());
        System.out.println((sun.misc.VM.maxDirectMemory() / (double)1024/1024)+"MB");
    }

    @Test
    public void testXml() {
        //第一种方法 主启动类里加@ImportResource(locations = {"classpath:spring01.xml"})
//        EmpService empService = (EmpService)context.getBean("empService");
//        empService.add();
        //第二种方法EmpConfig.java
        EmpService empService2 = (EmpService) context.getBean("empService2");
        empService2.add();
    }

    @Test
    public void contextLoads() {
//        System.out.println(emp);
        //1：下面定义的都是日志级别，由低到高trace<debug<info<warn<error
        //2: spring boot默认info级别也称为root级别
        //3: 可以通过配置文件进行修改日志级别，设置后，只打印高于这个级别的信息
        //    没有指定级别的就用默认级别就是root级别(info)----root级别也可以修改在配置文件里可以改
        //跟踪运行信息
        logger.trace("这是trace日志信息");
        //调试信息
        logger.debug("debug");
        logger.info("这是INFO自定义信息");
        logger.warn("警告信息");
        logger.error("这是ERROR信息记录错误的");
    }

}
