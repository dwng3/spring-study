package com.example.spring_study.service;


import com.example.spring_study.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public Post createPost(Post post);

    public List<Post> getAllPosts();

    public ResponseEntity<Post> getPostById(Long id);

    public ResponseEntity<Post> updatePost(Long id, Post updatedPost);

    public ResponseEntity<Void> deletePost(Long id);
}
