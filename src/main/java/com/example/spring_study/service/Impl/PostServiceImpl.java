package com.example.spring_study.service.Impl;

import com.example.spring_study.dto.CreatePostRequest;
import com.example.spring_study.dto.CursorPaginationResponse;
import com.example.spring_study.entity.Post;
import com.example.spring_study.entity.User;
import com.example.spring_study.repository.PostRepository;
import com.example.spring_study.repository.UserRespository;
import com.example.spring_study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRespository userRespository;

    @Override
    public Post createPost(CreatePostRequest req) {
        User user = userRespository.findById(req.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public CursorPaginationResponse<Post> getNextPosts(Long lastId, int limit) {
        if(lastId == null){
            lastId = 0L;
        }
        Page<Post> page = postRepository.findByIdGreaterThan(lastId, PageRequest.of(0, limit));
        List<Post> posts = page.getContent();

        String nextPage = null;
        if(!posts.isEmpty()) {
            Long lastPostId = posts.get(posts.size()-1).getId();
            nextPage = "/post/cursor?lastId=" + lastPostId + "&limit=" + limit;
        }
        return new CursorPaginationResponse<>(posts, nextPage);
    }


    @Override
    public ResponseEntity<Post> getPostById(Long id) {
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Post> updatePost(Long id, Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    if (updatedPost.getTitle() != null){
                        post.setTitle(updatedPost.getTitle());
                    }
                    if (updatedPost.getContent() != null){
                        post.setContent(updatedPost.getContent());
                    }
                    return ResponseEntity.ok(postRepository.save(post));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        if(postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
