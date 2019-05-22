package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends CrudRepository<ContentEntity, Long> {
    ContentEntity findByItemName(String itemName);
    List<ContentEntity> findAllByUserProfile(UserProfileEntity userProfile);
}
