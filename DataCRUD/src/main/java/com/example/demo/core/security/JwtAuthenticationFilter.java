package com.example.demo.core.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    // **

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String prefixJwt = request.getHeader(JwtTokenProvider.HEADER);

        // ** 헤더가 없다면 이 메소드에서 더 할 일은 없음, 다음으로 넘김.
        if (prefixJwt == null){
            chain.doFilter(request,response);
            return;
        }

        // ** Bearer 제거
        String jwt = prefixJwt.replace(JwtTokenProvider.TOKEN_PREFIX,"");

        try {
            log.debug("토큰 있음.");
            DecodedJWT decodedJWT = JwtTokenProvider.verify(jwt);
        }
        catch (AuthenticationException ex) {

        }

        chain.doFilter(request, response);
    }
}
