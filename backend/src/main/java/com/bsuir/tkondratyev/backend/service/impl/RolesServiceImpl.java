package com.bsuir.tkondratyev.backend.service.impl;

import com.bsuir.tkondratyev.backend.repository.RolesRepository;
import com.bsuir.tkondratyev.backend.service.RolesService;
import com.bsuir.tkondratyev.backend.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) rolesRepository.findAll();
    }

    @Override
    public RoleEntity findByName(String name) {
        return rolesRepository.findByName(name);
    }

    @Override
    public RoleEntity save(RoleEntity roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Optional<RoleEntity> findById(Long id) { return rolesRepository.findById(id); }
}
