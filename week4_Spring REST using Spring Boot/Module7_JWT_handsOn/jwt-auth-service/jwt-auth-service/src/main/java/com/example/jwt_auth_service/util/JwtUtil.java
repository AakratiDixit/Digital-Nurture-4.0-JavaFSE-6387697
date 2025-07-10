package com.example.jwt_auth_service.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.nio.charset.StandardCharsets;

public class JwtUtil {

    // Plain text secret key that matches jwt.io verification
    private static final String SECRET_KEY = "secretkey123";

    public static String generateToken(String username) {
        long expirationTimeInMs = 600_000; // 10 minutes

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMs))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8)) // Compatible with jjwt 0.9.x
                .compact();
    }
}
