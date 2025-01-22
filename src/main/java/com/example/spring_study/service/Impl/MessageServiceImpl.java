package com.example.spring_study.service.Impl;

import com.example.spring_study.dto.ChatMessage;
import com.example.spring_study.entity.Message;
import com.example.spring_study.repository.MessageRepository;
import com.example.spring_study.repository.UserRespository;
import com.example.spring_study.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private UserRespository userRespository;

    @Override
    public Message saveMessage(ChatMessage chatMessage) {
        Message message = new Message();
        message.setSender(userRespository.findById(Long.parseLong(chatMessage.getSender())).orElseThrow());
        message.setReceiver(userRespository.findById(Long.parseLong(chatMessage.getReceiver())).orElseThrow());
        message.setContent(chatMessage.getContent());
        message.setTimeStamp(LocalDateTime.now());

        return messageRepository.save(message);
    }
}
