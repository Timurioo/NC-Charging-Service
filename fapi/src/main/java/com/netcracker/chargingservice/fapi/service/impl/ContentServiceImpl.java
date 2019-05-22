package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.Content;
import com.netcracker.chargingservice.fapi.service.ContentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Content> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Content[] contentResponse = restTemplate.getForObject(backendServerUrl + "/api/content/all", Content[].class);
        return contentResponse == null ? Collections.emptyList() : Arrays.asList(contentResponse);
    }

    @Override
    public Content findByItemName(String itemName) {
        RestTemplate restTemplate = new RestTemplate();
        Content content = restTemplate.getForObject(backendServerUrl + "/api/content/" + itemName, Content.class);
        return content;
    }

    @Override
    public Content saveContent(Content content) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/content", content, Content.class).getBody();
    }

    @Override
    public void deleteContent(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/content/" + id);
    }

    @Override
    public List<Content> findAllByUserProfile(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Content[] contents = restTemplate.getForObject(backendServerUrl + "/api/content/company/" + id, Content[].class);
        return contents == null ? Collections.emptyList() : Arrays.asList(contents);
    }
}
