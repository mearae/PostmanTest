package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Setter
    @Getter
    public static class loginDto{

        private String email;

        private String password;
    }
}
