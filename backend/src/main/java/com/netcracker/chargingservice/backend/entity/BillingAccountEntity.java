package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_account", schema = "charging_service")
public class BillingAccountEntity {

    private Long id;
    private int funds;
    private Byte isActive;
    private UserProfileEntity userProfileId;

    public BillingAccountEntity(int funds, Byte isActive) {
        this.funds = funds;
        this.isActive = isActive;
    }

    public BillingAccountEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "funds")
    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    @Basic
    @Column(name = "is_active")
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

    @ManyToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false)
    public UserProfileEntity getUserProfileByUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileByUserProfileId(UserProfileEntity userProfileId) {
        this.userProfileId = userProfileId;
    }
}
