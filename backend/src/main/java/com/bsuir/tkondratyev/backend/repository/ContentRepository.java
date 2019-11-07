package com.bsuir.tkondratyev.backend.repository;

import com.bsuir.tkondratyev.backend.entity.ContentEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends CrudRepository<ContentEntity, Long> {
    ContentEntity findByItemName(String itemName);
    List<ContentEntity> findAllByUserProfile(UserProfileEntity userProfile);
}
