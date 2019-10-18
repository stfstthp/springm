package com.stt.mybatis.controller;

import com.stt.mybatis.entities.Provider;
import com.stt.mybatis.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid") Integer pid) {
        Provider providerByPid = providerMapper.getProviderByPid(pid);
        return providerByPid;
    }

    @GetMapping("/provider")
    public Provider addProvider(Provider provider) {
        providerMapper.addProvider(provider);
        return provider;
    }
}
