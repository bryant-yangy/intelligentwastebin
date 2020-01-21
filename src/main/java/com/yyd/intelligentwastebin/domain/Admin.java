package com.yyd.intelligentwastebin.domain;

public class Admin {
    private  int id;
    private String adminName;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(int id, String adminName, String password) {

        this.id = id;
        this.adminName = adminName;
        this.password = password;
    }

    public Admin() {

    }
}
