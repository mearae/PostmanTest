package com.example.demo.core.security;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration // ** 현재 클래스를 (설정 클래스)로 설정
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{

        return authenticationConfiguration.getAuthenticationManager();
        // BCrypt : 기본으로 상요, 가장 많이 사용되는 알고리즘
        // SCrypt : 개발자가 직접 필요에 따라 변경 가능
        // Argon2
        // PBKBF2
        // MDS (현재는 안 씀)
        // SHA-1, SHA-256 (현재는 안 씀) 등등
    }

    // ** 스프링 빈 등록 -> 프로그램 실행 시 따로 부르지 않아도 자동으로 실행
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity) throws Exception{
        // ** Security 기본 인증을 비활성화
        httpSecurity.httpBasic().disable();

        return httpSecurity.build();
    }
}
