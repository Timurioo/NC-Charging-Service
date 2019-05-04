package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/billing")
public class BillingAccountController {

    @Autowired
    BillingAccountService billingAccountService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BillingAccountEntity> getAllAccounts() {
        return billingAccountService.getAllBillingAccounts();
    }

    @GetMapping(path = "/id/{id}")
    public @ResponseBody Optional<BillingAccountEntity> getAccountById(@PathVariable Long id) {
        return billingAccountService.getBillingAccountById(id);
    }

    @PostMapping(path = "/new")
    public BillingAccountEntity saveAccount(@RequestBody BillingAccountEntity account) {
        return billingAccountService.saveBillingAccount(account);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAccount(@PathVariable Long id) {
        billingAccountService.deleteBillingAccount(id);
    }
}
