package com.example.spring_study.service;

import com.example.spring_study.dto.ChatMessage;
import com.example.spring_study.entity.Message;

public interface MessageService {

    public Message saveMessage(ChatMessage chatMessage);
}
