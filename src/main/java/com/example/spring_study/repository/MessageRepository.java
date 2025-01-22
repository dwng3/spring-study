package com.example.spring_study.repository;

import com.example.spring_study.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllBySenderIdAndReceiverIdOrderByTimestamp(Long senderId, Long receiverId);
}
