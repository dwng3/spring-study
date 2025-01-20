package com.example.spring_study.controller;

import com.example.spring_study.entity.Story;
import com.example.spring_study.entity.User;
import com.example.spring_study.service.Impl.StoryServiceImpl;
import com.example.spring_study.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stories")
public class StoryController {

    private final StoryServiceImpl storyService;

    @GetMapping("/{userId}")
    public List<Story> getUserStories(@PathVariable Long userId) {
        return storyService.getUserStories(userId);
    }
}
