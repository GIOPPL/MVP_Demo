package com.gioppl.mvp_demo.bean;

public class UserBean {
    private String name;
    private String nickName;
    private String address;
    private int age;

    public UserBean(String nickName, String address, int age) {
        this.nickName = nickName;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
