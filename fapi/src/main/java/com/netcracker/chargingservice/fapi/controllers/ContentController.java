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

    @GetMapping(path="/all")
    public ResponseEntity<List<Content>> getAllProducts() { return ResponseEntity.ok(contentService.findAll()); }

    @PostMapping(path="", produces = "application/json")
    public ResponseEntity<Content> saveProduct(@RequestBody Content content) {
        if (content != null)
            return ResponseEntity.ok(contentService.saveContent(content));
        return ResponseEntity.notFound().build();
    }
}
