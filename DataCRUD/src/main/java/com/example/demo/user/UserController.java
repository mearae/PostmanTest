package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
// ** 생성자를 통해 UserService를 초기화 하는 대신 @RequiredArgsConstructor 추가
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // @Valid : 받아온 폼의 데이터의 유효성을 검사하는 역할을 수행
    // - @RequestBody, @ModelAttribute 과 함께 사용
    // - DTO에서 작성된 @Size, @Pattern, @NotEmpty 등등을 검사
    // - 필드에 'NOT NULL' 조건이 있거나, 'UNIQUE' 조건이 설정되어 있는 경우도 확인
    @GetMapping("/join")
    public String login(@Valid UserRequest.LoginDto loginDto){

        String byEmail = userService.findByEmail(loginDto.getEmail());

        return byEmail;
    }
}
