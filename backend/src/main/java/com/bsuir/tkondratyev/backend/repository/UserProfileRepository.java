package com.bsuir.tkondratyev.backend.repository;

import com.bsuir.tkondratyev.backend.entity.RoleEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Long> {
    Optional<UserProfileEntity> findByEmail(String email);
    List<UserProfileEntity> findByRole(RoleEntity role);
}
