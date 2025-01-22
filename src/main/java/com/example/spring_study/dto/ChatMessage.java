package com.example.spring_study.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    private String sender;
    private String receiver;
    private String content;
}
