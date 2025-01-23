package com.example.spring_study.service;

import com.example.spring_study.entity.Collection;

import java.util.List;

public interface CollectionService {

    public List<Collection> getCollectionList(Long userId);

    public Collection getCollectionById(Long id);

    public Collection createCollection(String title);
}
