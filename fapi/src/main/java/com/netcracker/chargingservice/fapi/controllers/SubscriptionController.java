package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.Subscription;
import com.netcracker.chargingservice.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(path = "/wallet/{id}")
    public ResponseEntity<List<Subscription>> findByBillingAccount(@PathVariable(name = "id") Long id) {
        List<Subscription> subscriptions = subscriptionService.findByBillingAccount(id);
        if(!subscriptions.isEmpty()){
            return ResponseEntity.ok(subscriptions);
        }else {
            return ResponseEntity.ok(null);
        }
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path = "/new")
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        if (subscription != null) {
            return ResponseEntity.ok(subscriptionService.save(subscription));
        }
        return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path = "/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.delete(id);
    }
}
