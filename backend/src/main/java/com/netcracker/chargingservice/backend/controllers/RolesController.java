package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.RoleEntity;
import com.netcracker.chargingservice.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping(path="/all")
    public @ResponseBody
    List<RoleEntity> getAllRoles() {
        return rolesService.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewRole(@RequestParam String name) {
        RoleEntity role = new RoleEntity(name);
        rolesService.save(role);
        return "Saved";
    }
}
