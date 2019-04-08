package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.RolesEntity;
import com.netcracker.chargingservice.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/test-roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping(path="/all-roles")
    public @ResponseBody
    List<RolesEntity> getAllRoles() {
        return rolesService.findAll();
    }

    @GetMapping(path="/add-roles")
    public @ResponseBody String addNewRole(@RequestParam String name) {
        RolesEntity role = new RolesEntity(name);
        rolesService.save(role);
        return "Saved";
    }
}
