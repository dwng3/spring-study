package com.example.spring_study.controller;

import com.example.spring_study.dto.CreatePostRequest;
import com.example.spring_study.entity.Post;
import com.example.spring_study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    // Create
    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest req) {
        return postService.createPost(req);
    }

    // Read All
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // Update
    @PatchMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
