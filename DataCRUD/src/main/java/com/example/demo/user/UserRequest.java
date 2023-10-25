package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collections;

public class UserRequest {

    @Setter
    @Getter
    public static class JoinDto {

        // 데이터가 비어있을 수 없음
        @NotEmpty
        @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "유효한 이메일 주소를 입력해주세요.")
        private String email;
        // ^[A-Za-z0-9+_.-]+: 이메일 주소의 로컬 파트로 영문 대소문자, 숫자, 특수문자(+, _, ., -)가 포함될 수 있음
        //@[A-Za-z0-9.-]+$: @ 기호 뒤에 도메인 파트로 영문 대소문자, 숫자, 점(.), 하이픈(-)이 포함될 수 있음

        @NotEmpty(message = "비밀번호를 입력해주세요.")
        @Size(min = 8, max = 20, message = "8자 이상 20자 이내로 작성 가능합니다.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!@#$%^&*()_~+=\\[\\]|\\\\;:'\"<>,.?/-])[A-Za-z\\d@#$%^&+=!@#$%^&*()_~+=\\[\\]|\\\\;:'\"<>,.?/-]{8,20}$", message = "영문자, 숫자, 특수문자를 혼합하여 입력해주세요.")
        private String password;
        // ^(?=.*[A-Za-z]): 적어도 하나의 영문자가 포함되어야 함
        // (?=.*\\d): 적어도 하나의 숫자가 포함되어야 함
        // (?=.*[@#$%^&+=!@#$%^&*()_~+=[\]|\\;:'"<>,.?/-]): 적어도 하나의 특수문자(!, @, #, $, %, ^, &, *, (, ), _, ~, +, [,],|,\,;,:,',",<,>, , ,.? / -)가 포함되어야 함
        // [A-Za-z\d@#$%^&+=!@#$%^&*()_~+=[\]|\\;:'"<>,.?/-]{8,20}: 영문자, 숫자 및 특수문자만 허용하며, 8~20글자여야 함

        @NotEmpty
        private String username;

        public User toEntity(){
            return User.builder()
                    .email(email)
                    .password(password)
                    .username(username)
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();
        }
    }
}
