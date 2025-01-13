package com.example.spring_study.service;

import com.example.spring_study.dto.LoginRequest;
import com.example.spring_study.entity.User;
import com.example.spring_study.repository.UserRespository;
import lombok.RequiredArgsConstructor;

public interface UserService {

    public void registerUser(User user);

    public String login(LoginRequest loginRequest);
}
