package com.netcracker.chargingservice.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccount {

    private Long id;
    private Long walletId;
    private int funds;
    private Byte isActive;
    private UserProfile userProfile;

    public BillingAccount(Long id, int funds, Long walletId, Byte isActive, UserProfile userProfile) {
        this.id = id;
        this.funds = funds;
        this.isActive = isActive;
        this.walletId = walletId;
        this.userProfile = userProfile;
    }

    public BillingAccount() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAccount that = (BillingAccount) o;

        if (id != that.id) return false;
        if (funds != that.funds) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;

        return true;
    }


    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
