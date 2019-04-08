package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "content", schema = "charging_service")
public class ContentEntity {
    private int id;
    private String itemName;
    private String pic;
    private String desc;
    private Integer cost;
    private UserProfileEntity userProfileId;
    private SubscriptionEntity subscriptionId;

    public ContentEntity(String itemName, String pic, String desc, Integer cost) {
        this.itemName = itemName;
        this.pic = pic;
        this.desc = desc;
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
    @Column(name = "ITEM_NAME")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "PIC")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "DESC")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "COST")
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
        if (pic != null ? !pic.equals(that.pic) : that.pic != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false)
    public UserProfileEntity getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UserProfileEntity userProfileId) {
        this.userProfileId = userProfileId;
    }

    @ManyToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = false)
    public SubscriptionEntity getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionEntity subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
