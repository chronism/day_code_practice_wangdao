package com.cskaoyan.domain;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String hobbies;

    private String userdetail;

    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies == null ? null : hobbies.trim();
    }

    public String getUserdetail() {
        return userdetail;
    }

    public void setUserdetail(String userdetail) {
        this.userdetail = userdetail == null ? null : userdetail.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}