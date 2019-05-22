package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;

import java.util.List;

public interface ContentService {
    List<ContentEntity> findAll();
    ContentEntity findByItemName(String itemName);
    ContentEntity saveContent(ContentEntity content);
    void deleteContent(Long id);
    List<ContentEntity> findAllByUserProfile(UserProfileEntity userProfile);
}
