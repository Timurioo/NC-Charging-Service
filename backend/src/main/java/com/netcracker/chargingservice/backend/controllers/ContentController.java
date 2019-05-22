package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.service.ContentService;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping(path="/all")
    public @ResponseBody List<ContentEntity> getAllProducts() { return contentService.findAll(); }

    @PostMapping("")
    public @ResponseBody ContentEntity saveProduct(@RequestBody ContentEntity content) {
       return contentService.saveContent(content);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        contentService.deleteContent(id);
    }

    @GetMapping(path = "/{itemName}")
    public @ResponseBody ContentEntity getProductByItemName(@PathVariable (name = "itemName") String name) {
        return contentService.findByItemName(name);
    }

    @GetMapping(path = "/company/{id}")
    public @ResponseBody List<ContentEntity> getAllByCompany(@PathVariable (name = "id") Long id) {
        Optional<UserProfileEntity> company = userProfileService.findById(id);
        return company.map(company1 -> contentService.findAllByUserProfile(company1)).orElse(null);
    }
}
