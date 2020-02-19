package com.esliceu.springbootintento.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenManager {
    String SECRET_KEY = "hola";
    public String createToken(String user){
        String token = Jwts.builder().claim("username",user)
                .setExpiration(new Date(System.currentTimeMillis() + 360000))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(SECRET_KEY))
                .compact();
        return token;
    }
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY.getBytes()).parseClaimsJws(token).getBody();
            return claims != null;
        } catch (Exception e) {
            return false;
        }
    }
}
