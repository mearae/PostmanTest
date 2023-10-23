package com.example.demo.core.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration // ** 현재 클래스를 (설정 클래스)로 설정
public class SecurityConfig {
    // ** 스프링 빈 등록 -> 프로그램 실행 시 따로 부르지 않아도 자동으로 실행
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        // ** Security 기본 인증을 비활성화
        httpSecurity.httpBasic().disable();

        return httpSecurity.build();
    }
}
