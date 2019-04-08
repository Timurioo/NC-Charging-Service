package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_account", schema = "charging_service")
public class BillingAccountEntity {
    private int id;
    private int funds;
    private Byte isActive;
    private UserProfileEntity userProfileId;

    public BillingAccountEntity(int funds, Byte isActive) {
        this.funds = funds;
        this.isActive = isActive;
    }

    public BillingAccountEntity() {}

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FUNDS")
    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    @Basic
    @Column(name = "ISACTIVE")
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

        BillingAccountEntity that = (BillingAccountEntity) o;

        if (id != that.id) return false;
        if (funds != that.funds) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + funds;
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false)
    public UserProfileEntity getUserProfileByUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileByUserProfileId(UserProfileEntity userProfileId) {
        this.userProfileId = userProfileId;
    }
}
