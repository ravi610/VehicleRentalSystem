package com.lld.vehiclerental.model;

import com.lld.vehiclerental.utils.CommonUtils;

public class User {
    private String userId;
    private String licenceId;
    private String phone;
    private String email;

    public User(String licenceId, String phone, String email) {
        this.userId = CommonUtils.generateUuid(15);
        this.licenceId = licenceId;
        this.phone = phone;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
