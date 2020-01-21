package com.yyd.intelligentwastebin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Indent {
    private int id;
    private String userName;
    private String productName;
    private int account;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Indent() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", account=" + account +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }

    public Indent(int id, String userName, String productName, int account, Date date, String name) {
        this.id = id;
        this.userName = userName;
        this.productName = productName;
        this.account = account;
        this.date = date;
        this.name = name;
    }
}
