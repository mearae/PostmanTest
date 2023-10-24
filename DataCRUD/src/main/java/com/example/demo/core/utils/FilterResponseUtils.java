package com.example.demo.core.utils;

import com.example.demo.core.error.exception.Exception401;
import com.example.demo.core.error.exception.Exception403;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterResponseUtils {

    public static void unAuthorized(HttpServletResponse response, Exception401 e) throws IOException {
        // ** Http 응답 설정
        response.setStatus(e.status().value());
        response.setContentType("application/json; charset=utf-8");

        // ** json을 문자열로 변경 후 응답
        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = objectMapper.writeValueAsString(e.body());
        response.getWriter().println(responseBody);
    }

    public static void forbidden(HttpServletResponse response, Exception403 e) throws IOException {
        response.setStatus(e.status().value());
        response.setContentType("application/json; charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = objectMapper.writeValueAsString(e.body());
        response.getWriter().println(responseBody);
    }
}
