package com.esliceu.springbootintento.handlers;

import com.esliceu.springbootintento.manager.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            System.out.println("prehandler :)");

            String auth = request.getHeader("Authorization");

            System.out.println(auth);
            if (auth != null && !auth.isEmpty()) {
                String token = auth.replace("Bearer ", "");
                boolean valid = tokenManager.validateToken(token);
                if (!valid){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }else {
                    response.setStatus(HttpServletResponse.SC_OK);
                }
                return tokenManager.validateToken(token);
            }
            return true;
        }catch (JwtException e){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN,e.getMessage());
        }
        return false;
    }

}