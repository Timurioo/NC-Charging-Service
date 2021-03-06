package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.Content;

import java.util.List;

public interface ContentService {
    List<Content> findAll();
    Content findByItemName(String itemName);
    Content saveContent(Content content);
    void deleteContent(Integer id);
    List<Content> findAllByUserProfile(Long id);
}
