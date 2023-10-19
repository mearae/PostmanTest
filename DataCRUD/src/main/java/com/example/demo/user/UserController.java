package com.example.demo.user;

import com.example.demo.core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
// ** 생성자를 통해 UserService를 초기화 하는 대신 @RequiredArgsConstructor 추가
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    // @Valid : 받아온 폼의 데이터의 유효성을 검사하는 역할을 수행
    // - @RequestBody, @ModelAttribute 과 함께 사용
    // - DTO에서 작성된 @Size, @Pattern, @NotEmpty 등등을 검사
    // - 필드에 'NOT NULL' 조건이 있거나, 'UNIQUE' 조건이 설정되어 있는 경우도 확인
    //
    // @RequestBody
    // json으로 넘어오는 데이터를 UserRequest.LoginDTO 형태로 변경 해주는 역할
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserRequest.LoginDto loginDto){
        // ResponseEntity<?> : json 변경
        // 변경할 데이터의 형태가 모두 다를 수 있기 때문에 <?> 형태로 변환
        userService.join(loginDto);
        //userRepository.save(loginDto.toEntity());

        return ResponseEntity.ok(ApiUtils.success(null));
        //return ResponseEntity.ok(ApiUtils.error("meessage"));
    }
}
