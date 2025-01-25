package com.example.spring_study.controller;


import com.example.spring_study.dto.AddPostCollectionDTO;
import com.example.spring_study.entity.Collection;
import com.example.spring_study.service.Impl.CollectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/collection")
public class CollectionController {

    private final CollectionServiceImpl collectionService;

    @GetMapping("/{userId}")
    public List<Collection> getAllCollection(@PathVariable Long userId){
        return collectionService.getCollectionList(userId);
    }

    @GetMapping("/{collectionId}")
    public Collection getCollection(@PathVariable Long collectionId) {
        return collectionService.getCollectionById(collectionId);
    }

    @PostMapping
    public Collection createCollection(@RequestBody String title) {
        return collectionService.createCollection(title);
    }

    @PostMapping("/{collectionId}/posts")
    public ResponseEntity<String> addPostCollection(@PathVariable Long collectionId, @RequestBody AddPostCollectionDTO dto){
        collectionService.
    }
}
