package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.Content;
import com.netcracker.chargingservice.fapi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Content>> getAllProducts() {
        return ResponseEntity.ok(contentService.findAll());
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Content> saveProduct(@RequestBody Content content) {
        if (content != null)
            return ResponseEntity.ok(contentService.saveContent(content));
        return ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/{itemName}")
    public ResponseEntity<Content> getProductByItemName(@PathVariable(name = "itemName") String name) {
        if (name != null) {
            Content content = contentService.findByItemName(name);
            return content != null ? ResponseEntity.ok(contentService.findByItemName(name)) : ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/company/{id}")
    public ResponseEntity<List<Content>> getProductByCompany(@PathVariable(name = "id") Long id) {
        List<Content> contents = contentService.findAllByUserProfile(id);
        if (!contents.isEmpty()) {
            return ResponseEntity.ok(contents);
        } else {
            return ResponseEntity.ok(null);
        }
    }
}
