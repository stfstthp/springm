package com.stfstt.springm.controller;

import com.stfstt.springm.dao.ProviderDao;
import com.stfstt.springm.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;

    //    @RequestMapping(value = "providers",method = RequestMethod.GET)
    @GetMapping("/providers")
    public String list(Map<String, Object> map,
                       @RequestParam(value = "providerName", required = false) String providerName) {
        logger.info("供应商列表查询");
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providerName", providerName);
        map.put("providers", providers);
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + pid + "供应商列表查询");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider", provider);
//        return "provider/view";
        return "provider/" + type;
    }

    //修改
    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("更改供应商信息。。。。。。。。");
        providerDao.save(provider);
        return "redirect:providers";
    }

    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }

    //添加
    @PostMapping("/provider")
    public String add(Provider provider) {
        logger.info("添加供应商数据" + provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除供应商 pid=" + pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
