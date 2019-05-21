package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.entity.SubscriptionEntity;
import com.netcracker.chargingservice.backend.service.BillingAccountService;
import com.netcracker.chargingservice.backend.service.ContentService;
import com.netcracker.chargingservice.backend.service.SubscriptionService;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    BillingAccountService billingAccountService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    ContentService contentService;

    @PostMapping(path = "/new")
    public @ResponseBody SubscriptionEntity saveSubscription( @RequestBody SubscriptionEntity subscription) {
        Integer price = subscription.getContent().getCost();
        ArrayList<BillingAccountEntity> companyWallet = (ArrayList<BillingAccountEntity>) billingAccountService.getAllByUserProfile(contentService.findByItemName(subscription.getContent().getItemName()).getUserProfile());
        BillingAccountEntity userWallet = subscription.getBillingAccount();
        companyWallet.get(0).setFunds(companyWallet.get(0).getFunds() + price);
        userWallet.setFunds(userWallet.getFunds() - price);
        billingAccountService.saveBillingAccount(companyWallet.get(0));
        billingAccountService.saveBillingAccount(userWallet);
        return subscriptionService.save(subscription);
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<SubscriptionEntity> getAllSubscriptions() {
        return subscriptionService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSubscription(@PathVariable (name = "id") Long id) {
        subscriptionService.delete(id);
    }

    @GetMapping (path = "/wallet/{id}")
    public @ResponseBody List<SubscriptionEntity> getAllByWallet(@PathVariable (name = "id") Long id) {
        Optional<BillingAccountEntity> billingAccountEntity = billingAccountService.getBillingAccountById(id);
        return billingAccountEntity.map(billingAccountEntity1 -> subscriptionService.findByBillingAccount(billingAccountEntity1)).orElse(null);
    }
}
