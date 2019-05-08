package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.Subscription;
import com.netcracker.chargingservice.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Subscription> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Subscription[] subscriptionResponse = restTemplate.getForObject(backendServerUrl + "/api/subscription/all", Subscription[].class);
        return subscriptionResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionResponse);
    }

    @Override
    public Subscription save(Subscription subscription) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscription/new", subscription, Subscription.class).getBody();
    }

    @Override
    public List<Subscription> findByBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Subscription[] subscriptionResponse = restTemplate.getForObject(backendServerUrl + "/api/subscription/wallet/" + id, Subscription[].class);
        return subscriptionResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionResponse);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscription/" + id);
    }
}
