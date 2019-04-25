package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<ContentEntity, Long> {
    ContentEntity findByItemName(String itemName);
}
