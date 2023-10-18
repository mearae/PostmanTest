package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

        String byEmail = userService.findByEmail(loginDto.getEmail());

        return byEmail;
    }
}
