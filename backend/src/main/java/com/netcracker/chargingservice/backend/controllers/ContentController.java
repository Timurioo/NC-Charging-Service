package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.ContentEntity;
import com.netcracker.chargingservice.backend.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

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
}
