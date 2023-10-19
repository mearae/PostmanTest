package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest.LoginDto loginDto) {
        try {
            userRepository.save(loginDto.toEntity());
            findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findAll() {
        List<User> all = userRepository.findAll();

        System.out.println("id" + "\t\t" +
                "name" + "\t\t" +
                "email" + "\t\t\t\t\t" +
                "password");
        for (User user : all){
            user.output();
        }
    }
}
