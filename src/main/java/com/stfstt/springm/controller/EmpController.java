package com.stfstt.springm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class EmpController {
    @Value("${emp.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/say")
    public String say() {
        return "say hello" + name;
    }

    //    @RequestMapping("/execute")
    @GetMapping("/execute")
    public String success(Map<String, Object> map) {
        map.put("stf", "stt");
        map.put("name", "苏童童");
        return "provider/success";
    }

}
