package com.enigma.procurement.controllers.interceptors;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MiddlewareInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().contains(UrlMappings.AUTH_URL) || request.getRequestURI().contains("/admin")){
            return true;
        }
        return jwtUtil.validateToken(request.getHeader("Authorization").split(" ")[1]);
    }
}
