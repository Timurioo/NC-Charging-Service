package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.Content;
import com.netcracker.chargingservice.fapi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping(path="/all")
    public ResponseEntity<List<Content>> getAllProducts() { return ResponseEntity.ok(contentService.findAll()); }
}
