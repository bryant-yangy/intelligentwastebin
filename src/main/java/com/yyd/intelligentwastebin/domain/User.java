package com.yyd.intelligentwastebin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private int id;
   // @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    private String username;
    private String password;
    private String hasFace;
    private  int points;
    private String phone;
    private String name;

    public User(int id, Date createDate, String username, String password, String hasFace, int points, String phone, String name) {
        this.id = id;
        this.createDate = createDate;
        this.username = username;
        this.password = password;
        this.hasFace = hasFace;
        this.points = points;
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hasFace='" + hasFace + '\'' +
                ", points=" + points +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHasFace() {
        return hasFace;
    }

    public void setHasFace(String hasFace) {
        this.hasFace = hasFace;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User() {

    }

    public User(int id, Date createDate, String username, String password, String hasFace, int points) {

        this.id = id;
        this.createDate = createDate;
        this.username = username;
        this.password = password;
        this.hasFace = hasFace;
        this.points = points;
    }
}
