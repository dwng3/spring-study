package com.example.spring_study.service.Impl;

import com.example.spring_study.entity.Story;
import com.example.spring_study.entity.User;
import com.example.spring_study.repository.StoryRepository;
import com.example.spring_study.repository.UserRespository;
import com.example.spring_study.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final UserRespository userRespository;

    @Override
    public List<Story> getUserStories(Long userId) {
        User user = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자가 없습니다."));

        return storyRepository.findAllByUserAndExpiresAtAfter(user, LocalDateTime.now());
    }

    @Override
    public Story uploadStory(Long userId, String mediaUrl) {

        User user = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No user"));

        Story story = Story.builder()
                        .user(user)
                        .mediaUrl(mediaUrl)
                        .createdAt(LocalDateTime.now())
                        .expiresAt(LocalDateTime.now().plusHours(24))
                        .build();
        return storyRepository.save(story);
    }

    @Override
    @Scheduled(cron = "0 0 * * * *") // 매시간 실행
    public void deleteExpiredStories() {
        List<Story> expiredStories = storyRepository.findAllByExpiresAtBefore(LocalDateTime.now());
        if(!expiredStories.isEmpty()) {
            for (Story story : expiredStories) {
                File file = new File("uploads/" + story.getMediaUrl());
                if(file.exists()) {
                    file.delete();
                }
            }
        }
        storyRepository.deleteAll(expiredStories);
    }
}
