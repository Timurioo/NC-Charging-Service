package com.netcracker.chargingservice.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userProfile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isBlocked;

    public UserProfile() {

    }

    public UserProfile(String login, String email, String firstName, String lastName, boolean isBlocked) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBlocked = isBlocked;
    }

    @Basic
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name="login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name="firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name="lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name="isBlocked")
    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Basic
    @Column(name="")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile userProfile = (UserProfile) o;
        return id == userProfile.id &&
                Objects.equals(login, userProfile.login) &&
                Objects.equals(email, userProfile.email) &&
                Objects.equals(password, userProfile.password) &&
                Objects.equals(firstName, userProfile.firstName) &&
                Objects.equals(lastName, userProfile.lastName) &&
                Objects.equals(isBlocked, userProfile.isBlocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, firstName, lastName, isBlocked);
    }
}
