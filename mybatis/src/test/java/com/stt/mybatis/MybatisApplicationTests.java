package com.stt.mybatis;

import com.stt.mybatis.config.RedisService;
import com.stt.mybatis.controller.ProviderController;
import com.stt.mybatis.entities.Provider;
import com.stt.mybatis.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MybatisApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate jsonRedisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ProviderMapper providerMapper;
    @Resource
    private RedisService service;

    @Test
    public void t1(){
        System.out.println(37|3);
    }
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            String y = "1";
            boolean c = false;
            //step1 先从redis里面取值
            c = service.exists(y);
            //step2 如果拿不到则从DB取值
            if (!c) {
                Provider providerDB = providerMapper.getProviderByPid(Integer.parseInt(y));
                System.out.println("从DB取值" + providerDB);

                //step3 DB非空情况刷新redis值
                if (providerDB != null) {
                    service.set(y, "222", 5l);
                    System.out.println("刷新REDIS");
                }
            }

        }
    }

    @Test
    public void contextLoads() {
//        stringRedisTemplate.opsForValue().set("中文","英文");
//        String c = stringRedisTemplate.opsForValue().get("中文");
//        System.out.println(c);
//        jsonRedisTemplate.opsForValue().set("苏","腾");
        for (int i = 0; i < 90000; i++) {
//            Provider provider = new Provider();
//            provider.setProviderName(String.valueOf(i));
//            providerMapper.addProvider(provider);
            providerMapper.updatePro(i);
        }
//        List<Provider> provider = providerMapper.getProvider();
//        for (int i = 0; i <provider.size() ; i++) {
//            Provider p = provider.get(i);
//            System.out.println(p);
//        }

    }

}
