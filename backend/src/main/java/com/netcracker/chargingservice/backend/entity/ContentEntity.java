package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "content", schema = "charging_service")
public class ContentEntity {
    private int id;
    private String itemName;
    private String pictureUrl;
    private String description;
    private Integer cost;
    private UserProfileEntity userProfileId;
    private SubscriptionEntity subscriptionId;

    public ContentEntity(String itemName, String pictureUrl, String description, Integer cost) {
        this.itemName = itemName;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.cost = cost;
    }

    public ContentEntity() {
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
    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "picture_url")
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentEntity that = (ContentEntity) o;

        if (id != that.id) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(that.pictureUrl) : that.pictureUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = true)
    public UserProfileEntity getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UserProfileEntity userProfileId) {
        this.userProfileId = userProfileId;
    }

    @ManyToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = true)
    public SubscriptionEntity getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionEntity subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
