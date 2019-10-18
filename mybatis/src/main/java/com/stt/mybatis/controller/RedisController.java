package com.stt.mybatis.controller;

import com.stt.mybatis.config.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisService service;

    @RequestMapping("/redis/setandget1")
    @ResponseBody
    public String setAndGetValue1(String name, String value) {
        service.set(name, value);
        return (String) service.get(name);

    }

    @RequestMapping("/redis/del")
    @ResponseBody
    public void delValue(String name) {
        service.remove(name);
    }

    @RequestMapping("/redis/setandget")
    @ResponseBody
    public String setAndGetValue(String name, String value) {
        redisTemplate.opsForValue().set(name, value);
        return (String) redisTemplate.opsForValue().get(name);

    }

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
}
