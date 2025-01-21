package com.example.spring_study.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateStoryRequest {

    private Long userId;

    private String mediaUrl;
}

