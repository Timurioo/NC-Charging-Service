package com.bsuir.tkondratyev.backend.service;

import com.bsuir.tkondratyev.backend.entity.ContentEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;

import java.util.List;

public interface ContentService {
    List<ContentEntity> findAll();
    ContentEntity findByItemName(String itemName);
    ContentEntity saveContent(ContentEntity content);
    void deleteContent(Long id);
    List<ContentEntity> findAllByUserProfile(UserProfileEntity userProfile);
}
