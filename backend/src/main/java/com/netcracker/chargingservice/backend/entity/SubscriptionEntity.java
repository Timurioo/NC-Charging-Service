package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "subscription", schema = "charging_service")
public class SubscriptionEntity {
    private Long id;
    private String product;
    private Date date;
    private BillingAccountEntity billingAccount;

    public SubscriptionEntity(String product, Date date) {
        this.product = product;
        this.date = date;
    }

    public SubscriptionEntity() {
    }

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
    @Column(name = "product")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "purchase_date")
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

    @ManyToOne
    @JoinColumn(name = "billing_account_id", referencedColumnName = "id", nullable = false)
    public BillingAccountEntity getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccountEntity billingAccount) {
        this.billingAccount = billingAccount;
    }
}
