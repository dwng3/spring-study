package com.example.spring_study.repository;

import com.example.spring_study.entity.Story;
import com.example.spring_study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findAllByUserAndExpiresAtAfter(User user, LocalDateTime localDateTime);
    List<Story> findAllByExpiresAtBefore(LocalDateTime localDateTime);
}
