package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.BillingAccount;
import com.netcracker.chargingservice.fapi.service.BillingAccountDataService;
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

    @GetMapping(path="/all")
    public ResponseEntity<List<BillingAccount>> getAllAccounts() { return ResponseEntity.ok(billingAccountDataService.getAll()); }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/new")
    public ResponseEntity<BillingAccount> saveAccount(@RequestBody BillingAccount account) {
        if (account != null) {
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(account));
        }
        return ResponseEntity.badRequest().build();
    }
}
