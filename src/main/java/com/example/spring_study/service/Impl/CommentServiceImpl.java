package com.example.spring_study.service.Impl;

import com.example.spring_study.entity.Comment;
import com.example.spring_study.entity.Post;
import com.example.spring_study.repository.CommentRepository;
import com.example.spring_study.repository.PostRepository;
import com.example.spring_study.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    @Override
    public List<Comment> getAllCommentsByPost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("No Post"));

        return commentRepository.findByPost(post);
    }
}
