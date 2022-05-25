package com.medical.interceptor;

import com.medical.entity.LbUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义登录拦截器
 * @author: lixiang
 * @date: 2022/5/5
 * @version: 1.0版本
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        LbUser user = (LbUser) session.getAttribute("user");
        if (user == null) {//重定向到登录视图
            response.sendRedirect(request.getContextPath() + "/home/user/login");
            return false;
        }
        return true;
    }
}
