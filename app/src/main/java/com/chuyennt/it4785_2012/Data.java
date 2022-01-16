package com.chuyennt.it4785_2012;

public class Data {
    private String avatar;
    private String userName;
    private String email;
    private String name;
    private String address;
    private String phone;
    private String company;

    public Data(String avatar, String userName, String email) {
        this.avatar = avatar;
        this.userName = userName;
        this.email = email;
    }

    public Data(String avatar, String userName, String email, String name, String address, String phone, String company) {
        this.avatar = avatar;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.company = company;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
