package com.example.demo.core.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.user.StringArrayConverter;
import com.example.demo.user.User;

import java.util.Date;

public class JwtTokenProvider {
    private static final Long EXP = 1000L * 60 * 60;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    private static final String SECRET = "SECRET_KEY"; // 회사마다 다름

    public static String create(User user){
        StringArrayConverter stringArrayConverter = new StringArrayConverter();
        String roles = stringArrayConverter.convertToDatabaseColumn(
                user.getRoles()
        );
        String jwt = JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXP))
                .withClaim("id",user.getId())
                .withClaim("roles",roles)
                .sign(Algorithm.HMAC512(SECRET));

        return TOKEN_PREFIX + jwt;
    }

}
