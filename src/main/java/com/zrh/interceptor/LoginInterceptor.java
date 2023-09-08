package com.zrh.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器，用户权限判断
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("this is loginInterceptor");

        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            return true;
        }
        //如果session中不存在User则拦截执行，使页面跳转到登录页面
        response.sendRedirect("/user/goLogin");
        return false;
    }
}
