package com.stfstt.springm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/bills")
    public String list() {
        int i = 0;
        if (i == 0) {
            throw new RuntimeException("i不能为零");
        }
        return "bill/list";
    }
}
