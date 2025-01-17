package com.example.spring_study.service;

import com.example.spring_study.entity.Comment;
import com.example.spring_study.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public List<Comment> getAllCommentsByPost(Long postId);
}
