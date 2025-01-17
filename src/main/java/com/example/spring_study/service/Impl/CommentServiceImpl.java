package com.example.spring_study.service.Impl;

import com.example.spring_study.entity.Comment;
import com.example.spring_study.entity.Post;
import com.example.spring_study.entity.User;
import com.example.spring_study.repository.CommentRepository;
import com.example.spring_study.repository.PostRepository;
import com.example.spring_study.repository.UserRespository;
import com.example.spring_study.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRespository userRespository;
    private final PostRepository postRepository;



    @Override
    public List<Comment> getAllCommentsByPost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("No Post"));

        return commentRepository.findByPost(post);
    }

    @Override
    public Comment createComment(Long postId, Long userId, String content) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("No Post"));

        User user = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No User"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);

        return commentRepository.save(comment);
    }
}
