package com.example.spring_study.controller;

import com.example.spring_study.dto.CreateStoryRequest;
import com.example.spring_study.entity.Story;
import com.example.spring_study.service.Impl.StoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Story uploadStory(@RequestBody CreateStoryRequest dto) {
        return storyService.uploadStory(dto.getUserId(), dto.getMediaUrl());
    }
}
