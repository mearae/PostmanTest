package com.example.demo.core.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.user.StringArrayConverter;
import com.example.demo.user.User;

import java.util.Date;

public class JwtTokenProvider {
    // 1시간
    private static final Long EXP = 1000L * 60 * 60;
    // ** Authorizatin 헤더에 필요한 데이터
    public static final String TOKEN_PREFIX = "Bearer ";
    // ** 헤더
    public static final String HEADER = "Authorization";
    // ** 암호화 및 복호화에 필요한 키
    private static final String SECRET = "SECRET_KEY"; // 회사마다 다름

    // ** JWT 토큰 생성
    public static String create(User user){
        // ** StringArrayConverter 객체 생성
        StringArrayConverter stringArrayConverter = new StringArrayConverter();
        // ** User의 권한 정보를 String으로 변환
        String roles = stringArrayConverter.convertToDatabaseColumn(
                user.getRoles()
        );
        String jwt = JWT.create()
                .withSubject(user.getEmail())// ** 토큰의 대상정보 셋팅
                .withExpiresAt(new Date(System.currentTimeMillis() + EXP))// ** 시간 설정
                .withClaim("id",user.getId())// ** id 설정
                .withClaim("roles",roles)// ** 권한정보 설정
                .sign(Algorithm.HMAC512(SECRET));// ** JWT 생성 알고리즘 생성

        return TOKEN_PREFIX + jwt;
    }

    public static DecodedJWT verify(String jwt) throws SignatureVerificationException, TokenExpiredException {
        // ** 토큰 검증을 시작
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET)) // 검증 방법
                .build()
                .verify(jwt); // 검증 할 것

        return decodedJWT;
    }

}
