package com.yyd.intelligentwastebin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Deliver {
    private int id;
    private String userName;
    private String trash;
    private int points;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", trash='" + trash + '\'' +
                ", points=" + points +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }

    public Deliver(int id, String userName, String trash, int points, Date date, String name) {
        this.id = id;
        this.userName = userName;
        this.trash = trash;
        this.points = points;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTrash() {
        return trash;
    }

    public void setTrash(String trash) {
        this.trash = trash;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Deliver(String name,String userName, String trash, int points, Date date) {
        this.name=name;
        this.userName = userName;
        this.trash = trash;
        this.points = points;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Deliver() {

    }
}
