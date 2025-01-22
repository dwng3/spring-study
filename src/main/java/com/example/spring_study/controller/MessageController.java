package com.example.spring_study.controller;

import com.example.spring_study.dto.ChatMessage;
import com.example.spring_study.entity.Message;
import com.example.spring_study.service.Impl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceImpl messageService;

    @MessageMapping("/chat.send") // 클라이언트에서 보낸 메시지 처리
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        messageService.saveMessage(chatMessage);
        return chatMessage;
    }


}
