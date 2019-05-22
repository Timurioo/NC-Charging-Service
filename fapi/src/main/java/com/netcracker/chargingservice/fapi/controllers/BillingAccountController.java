package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.converters.RegisterUserConverterToUserProfile;
import com.netcracker.chargingservice.fapi.models.BillingAccount;
import com.netcracker.chargingservice.fapi.service.BillingAccountDataService;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/billing")
public class BillingAccountController {

    @Autowired
    private BillingAccountDataService billingAccountDataService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RegisterUserConverterToUserProfile converter;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/all")
    public ResponseEntity<List<BillingAccount>> getAllAccounts() {
        return ResponseEntity.ok(billingAccountDataService.getAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'COMPANY')")
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<List<BillingAccount>> getAccountByUser(@PathVariable(name = "id") Long id) {
        List<BillingAccount> billingAccounts = billingAccountDataService.getBillingAccountByUser(id);
        if(!billingAccounts.isEmpty()){
            return ResponseEntity.ok(billingAccounts);
        }else {
            return ResponseEntity.ok(null);
        }
    }

    @PreAuthorize("hasAnyRole('USER', 'COMPANY')")
    @PostMapping(path = "/new")
    public ResponseEntity<BillingAccount> saveAccount(@RequestBody BillingAccount account) {
        if (account != null) {
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(account));
        }
        return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(path = "/wallet-id/{walletId}")
    public ResponseEntity<BillingAccount> getAccountByWalletId(@PathVariable Long walletId) {
        if (walletId != null) return ResponseEntity.ok(billingAccountDataService.getBillingAccountByWalletId(walletId));
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(path = "id/{id}")
    public ResponseEntity<BillingAccount> getAccountById(@PathVariable(name = "id") Long id) {
        BillingAccount billingAccount = billingAccountDataService.getBillingAccountById(id);
        return billingAccount != null ? ResponseEntity.ok(billingAccount) : null;
    }
}