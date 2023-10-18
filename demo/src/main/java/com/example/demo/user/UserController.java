package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;


/*
    public UserController(UserService userService) {
        this.userService = userService;
    }
*/
// ** 생성자를 통해 UserService를 초기화 하는 대신 @RequiredArgsConstructor 추가
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping("/join")
    public String login(UserRequest.loginDto loginDto){

        if (userService.function(loginDto.getEmail()) == false){
            return "존재하지 않는 사용자 이메일 입니다.";
        }

        return "index.html";
    }
}
