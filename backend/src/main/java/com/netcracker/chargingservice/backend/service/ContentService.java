package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.ContentEntity;

import java.util.List;

public interface ContentService {
    List<ContentEntity> findAll();
    ContentEntity findByItemName(String itemName);
    ContentEntity save(ContentEntity content);
    void deleteContent(Integer id);
}
