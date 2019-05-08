package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscription", schema = "charging_service")
public class SubscriptionEntity {
    private Long id;
    private BillingAccountEntity billingAccount;
    private ContentEntity content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionEntity that = (SubscriptionEntity) o;

        if (id != that.id) return false;

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

    @ManyToOne
    @JoinColumn(name = "content_id", referencedColumnName = "id", nullable = false)
    public ContentEntity getContent() {
        return content;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }
}

