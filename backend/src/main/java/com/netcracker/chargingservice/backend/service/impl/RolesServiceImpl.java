package com.netcracker.chargingservice.backend.service.impl;

import com.netcracker.chargingservice.backend.entity.RolesEntity;
import com.netcracker.chargingservice.backend.repository.RolesRepository;
import com.netcracker.chargingservice.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> findAll() {
        return (List<RolesEntity>) rolesRepository.findAll();
    }

    @Override
    public RolesEntity findByName(String name) {
        return rolesRepository.findByName(name);
    }

    @Override
    public RolesEntity save(RolesEntity roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void delete(Integer id) {
        rolesRepository.deleteById(id);
    }
}
