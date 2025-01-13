package com.example.spring_study.dto;

import lombok.Data;

@Data
public class CreatePostRequest {

    private Long user_id;

    private String title;

    private String content;
}
