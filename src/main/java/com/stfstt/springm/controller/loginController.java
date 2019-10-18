package com.stfstt.springm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String, Object> map) {
        //判断用户名不为空,且密码为123
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            if (session.getAttribute("loginUser") != null) {
                return "redirect:/main.html";
            } else {
                session.setAttribute("loginUser", username);
                return "redirect:/main.html";
            }

        } else {
            map.put("msg", "用户名或者密码错误");
            return "main/login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //清空SESSION中的用户信息，再将SESSION进行注销
        session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:/index.html";
    }

}
