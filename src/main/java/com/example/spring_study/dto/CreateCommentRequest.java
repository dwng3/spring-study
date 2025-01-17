package com.example.spring_study.dto;

import lombok.Data;

@Data
public class CreateCommentRequest {

    private Long postId;

    private Long userId;

    private String content;
}
