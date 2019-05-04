package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.BillingAccount;
import com.netcracker.chargingservice.fapi.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BillingAccountDataServiceImpl implements BillingAccountDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<BillingAccount> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccount[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/billing/", BillingAccount[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);
    }

    @Override
    public BillingAccount getBillingAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/billing/id/" + id, BillingAccount.class);
    }
    @Override
    public BillingAccount saveBillingAccount(BillingAccount account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/billing/new", account, BillingAccount.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing/" + id);
    }
}
