package com.example.spring_study.service;


import com.example.spring_study.dto.CreatePostRequest;
import com.example.spring_study.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public Post createPost(CreatePostRequest req);

    public List<Post> getAllPosts();

    public Page<Post> getNextPosts(Long lastId, int limit);

    public ResponseEntity<Post> getPostById(Long id);

    public ResponseEntity<Post> updatePost(Long id, Post updatedPost);

    public ResponseEntity<Void> deletePost(Long id);
}
