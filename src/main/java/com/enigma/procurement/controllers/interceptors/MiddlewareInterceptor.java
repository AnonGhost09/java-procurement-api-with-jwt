package com.enigma.procurement.controllers.interceptors;

import com.enigma.procurement.constansts.UrlMappings;
import com.enigma.procurement.exception.UnauthorizedException;
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

        try{
            String token = request.getHeader("Authorization").split(" ")[1];

            if(token == null){
                throw new UnauthorizedException("Token empty");
            }

            return jwtUtil.validateToken(token);
        }catch (Exception e){
            throw new UnauthorizedException();
        }

    }
}
