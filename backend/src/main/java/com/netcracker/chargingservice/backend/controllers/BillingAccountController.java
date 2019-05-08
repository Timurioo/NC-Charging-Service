package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.service.BillingAccountService;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/billing")
public class BillingAccountController {

    @Autowired
    BillingAccountService billingAccountService;

    @Autowired
    UserProfileService userProfileService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<BillingAccountEntity> getAllAccounts() {
        return billingAccountService.getAllBillingAccounts();
    }

    @GetMapping(path = "/id/{id}")
    public @ResponseBody
    Optional<BillingAccountEntity> getAccountById(@PathVariable Long id) {
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

    @GetMapping(path = "/wallet-id/{walletId}")
    public ResponseEntity<BillingAccountEntity> getByWalletId(@PathVariable(name = "walletId") Long walletId) {
        return billingAccountService.getByWalletId(walletId).map(ResponseEntity::ok).orElse(null);
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody Iterable<BillingAccountEntity> getAllByUser(@PathVariable (name = "id") Long id) {
        Optional<UserProfileEntity> user = userProfileService.findById(id);
        return user.map(userProfileEntity -> billingAccountService.getAllByUserProfile(userProfileEntity)).orElse(null);
    }
}
