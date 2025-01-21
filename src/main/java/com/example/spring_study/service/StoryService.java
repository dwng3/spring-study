package com.example.spring_study.service;


import com.example.spring_study.entity.Story;
import com.example.spring_study.entity.User;

import java.util.List;

public interface StoryService {

    public List<Story> getUserStories(Long userId);

    public Story uploadStory(Long userId, String mediaUrl);

    public void deleteExpiredStories();
}
