package com.stfstt.springm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override//调用目标方法之前被拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        }
        //没有登录过
        request.setAttribute("msg", "没有权限，请先登陆！");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}
