package com.example.spring_study.service.Impl;

import com.example.spring_study.dto.LoginRequest;
import com.example.spring_study.entity.User;
import com.example.spring_study.repository.UserRespository;
import com.example.spring_study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {
        if(userRespository.existsByUsername(user.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRespository.save(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User loginuser = userRespository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), loginuser.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return generateToken(loginuser);
    }

    private String generateToken(User user){
        return "jwt-token-for-" + user.getUsername();
    }
}
