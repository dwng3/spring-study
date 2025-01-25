package com.example.spring_study.service.Impl;

import com.example.spring_study.dto.AddPostCollectionDTO;
import com.example.spring_study.entity.Collection;
import com.example.spring_study.repository.CollectionRepository;
import com.example.spring_study.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;

    @Override
    public List<Collection> getCollectionList(Long userId) {
        return collectionRepository.findByUserId(userId);
    }

    @Override
    public Collection getCollectionById(Long id) {
        return collectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Collection"));
    }

    @Override
    public Collection createCollection(String title) {
        Collection collection = new Collection(title);
        return collectionRepository.save(collection);
    }

    @Override
    public boolean addPostToCollection(Long collectionId, AddPostCollectionDTO dto) {

        Optional<Collection> collectionOpt = collectionRepository.findById(collectionId);
        if(collectionOpt.isEmpty()){
            return false;
        }
        // 추가 로직 필요
        return true;
    }


}
