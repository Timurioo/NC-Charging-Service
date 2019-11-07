package com.bsuir.tkondratyev.backend.charging;

import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.SubscriptionEntity;
import com.bsuir.tkondratyev.backend.service.BillingAccountService;
import com.bsuir.tkondratyev.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ChargingService {

    @Autowired
    BillingAccountService billingAccountService;

    @Autowired
    SubscriptionService subscriptionService;


    @Scheduled(fixedDelay = 3600000)
    //@Scheduled(cron = "0 0/30 * * * *" )
    public void moneyTransfer() {
        ArrayList<SubscriptionEntity> subs = (ArrayList<SubscriptionEntity>) subscriptionService.findAll();
        ArrayList<BillingAccountEntity> customerAccounts = new ArrayList<>();
        ArrayList<BillingAccountEntity> companyAccounts = new ArrayList<>();

        for (SubscriptionEntity sub : subs) {
            BillingAccountEntity customerWallet = sub.getBillingAccount();
            ArrayList<BillingAccountEntity> companyWallet = (ArrayList<BillingAccountEntity>) billingAccountService.getAllByUserProfile(sub.getContent().getUserProfile());
            Integer cost = sub.getContent().getCost();

            if (customerWallet.getFunds() < cost && sub.getIsBlocked() != (byte) 0) {
                sub.setIsBlocked((byte) 1);
                subscriptionService.save(sub);
            } else if (customerWallet.getFunds() == 0) {
                customerWallet.setIsActive((byte) 0);
                billingAccountService.saveBillingAccount(customerWallet);
            } else {
                sub.setIsBlocked((byte) 0);
                subscriptionService.save(sub);
                customerWallet.setFunds(customerWallet.getFunds() - cost);
                companyWallet.get(0).setFunds(companyWallet.get(0).getFunds() + cost);
                customerAccounts.add(customerWallet);
                companyAccounts.add(companyWallet.get(0));
            }
        }

        for (BillingAccountEntity ba: customerAccounts) {
            billingAccountService.saveBillingAccount(ba);
        }

        for (BillingAccountEntity compBa: companyAccounts) {
            billingAccountService.saveBillingAccount(compBa);
        }
    }
}
