package com.netcracker.chargingservice.backend.service.impl;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.repository.ContentRepository;
import com.netcracker.chargingservice.backend.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<ContentEntity> findAll() {
        return (List<ContentEntity>) contentRepository.findAll();
    }

    @Override
    public ContentEntity findByItemName(String itemName) {
        return contentRepository.findByItemName(itemName);
    }

    @Override
    public ContentEntity saveContent(ContentEntity content) {
        return contentRepository.save(content);
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }

    @Override
    public List<ContentEntity> findAllByUserProfile(UserProfileEntity userProfile) {
        return contentRepository.findAllByUserProfile(userProfile);
    }
}
