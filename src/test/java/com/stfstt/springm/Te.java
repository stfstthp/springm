package com.stfstt.springm;

import net.bytebuddy.build.ToStringPlugin;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author sutengfei
 * @version 1.0
 * @date 2019/9/23 22:37
 */
public class Te {
    static class OomTest {

    }

    public static void main(String[] args) {
//        while (true){
//            System.out.println("234234");
//        }
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OomTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }

        } catch (Exception e) {
            System.out.println("出现异常" + i);
            e.printStackTrace();
        }
    }
}
