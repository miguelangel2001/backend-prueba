package com.foodapp.authmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class SignUpModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{5,15}", message = "Username must be of length 5-15 alphabetical characters")
    private String userName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "Password must be of length 5-20 alphanumeric characters")
    private String password;

    @NotNull
    @Pattern(regexp = "[0-9]{10}", message = "Mobile number must be of 10 digits")
    private String mobileNo;

    @NotNull
    @Email
    private String email;

    // ====================
    // Getters y Setters
    // ====================

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
