package com.yyd.intelligentwastebin.domain;

public class Product {
    private int id;
    private String productName;
    private String infor;
    private int account;
    private String image;
    private  int points;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", infor='" + infor + '\'' +
                ", account=" + account +
                ", image='" + image + '\'' +
                ", points=" + points +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Product(int id, String productName, String infor, int account, String image, int points) {

        this.id = id;
        this.productName = productName;
        this.infor = infor;
        this.account = account;
        this.image = image;
        this.points = points;
    }

    public Product() {

    }
}
