package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "subscription", schema = "charging_service")
public class SubscriptionEntity {
    private int id;
    private String product;
    private Date date;
    private BillingAccountEntity billingAccountId;

    public SubscriptionEntity(String product, Date date) {
        this.product = product;
        this.date = date;
    }

    public SubscriptionEntity() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PRODUCT")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionEntity that = (SubscriptionEntity) o;

        if (id != that.id) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "billing_account_id", referencedColumnName = "id", nullable = false)
    public BillingAccountEntity getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(BillingAccountEntity billingAccountId) {
        this.billingAccountId = billingAccountId;
    }
}
