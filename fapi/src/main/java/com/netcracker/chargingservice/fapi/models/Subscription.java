package com.netcracker.chargingservice.fapi.models;

public class Subscription {
    private Long id;
    private BillingAccount billingAccount;
    private Content content;

    public Subscription() { }

    public Subscription(Long id, BillingAccount billingAccount, Content content) {
        this.id = id;
        this.billingAccount = billingAccount;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }


}
