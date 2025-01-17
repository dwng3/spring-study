package com.example.spring_study.service;

import com.example.spring_study.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public List<Comment> getAllCommentsByPost(Long postId);

    public Comment createComment(Long postId, Long userId, String content);
}
