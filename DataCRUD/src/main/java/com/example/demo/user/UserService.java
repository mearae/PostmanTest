package com.example.demo.user;

import com.example.demo.core.error.exception.Exception400;
import com.example.demo.core.error.exception.Exception401;
import com.example.demo.core.error.exception.Exception500;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(UserRequest.LoginDto loginDto) {
        // 이미 있는 이메일인지 확인
        checkEmail(loginDto.getEmail());
        // loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));

        try {
            userRepository.save(loginDto.toEntity());
        } catch (Exception e) {
            throw new Exception500(e.getMessage());
        }
    }

    public String login(UserRequest.LoginDto loginDto) {
        // ** 인증 작업
        try{
            return "Bearer " + "인증 완료";
        }catch (Exception e){
            // 401 반환
            throw new Exception401("인증되지 않음.");
        }
    }


        public void findAll() {
        List<User> all = userRepository.findAll();

        for (User user : all){
            user.output();
        }
    }

    public void checkEmail(String email){
        Optional<User> users = userRepository.findByEmail(email);
        if (users.isPresent()){
            throw new Exception400("이미 존재하는 이메일입니다. : " + email);
        }
    }
}
