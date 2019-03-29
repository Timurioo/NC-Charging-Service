package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "billingAccount")
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long funds;
    private boolean isActive;

    public BillingAccount(long funds, boolean isActive) {
        this.funds = funds;
        this.isActive = isActive;
    }

    public BillingAccount() {
    }

    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="funds")
    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }

    @Column(name="isActive")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingAccount that = (BillingAccount) o;
        return id == that.id &&
                funds == that.funds &&
                isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funds, isActive);
    }
}
