package com.springboot.carrental.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "mysecretkey";

    public static String generateToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();
        Date issueDate = new Date(currentTimeMillis);
        Date expirationDate = new Date(currentTimeMillis + 3600000L); // 1 hour
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(issueDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }
}
