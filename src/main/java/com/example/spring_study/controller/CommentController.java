package com.example.spring_study.controller;

import com.example.spring_study.entity.Comment;
import com.example.spring_study.service.Impl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentServiceImpl commentService;

    @GetMapping
    public List<Comment> getAllCommentsByPost(@RequestBody Long postId) {
        return commentService.getAllCommentsByPost(postId);
    }
}
