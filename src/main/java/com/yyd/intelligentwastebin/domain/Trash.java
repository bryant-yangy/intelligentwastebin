package com.yyd.intelligentwastebin.domain;

public class Trash {
    private int id;
    private String trashName;
    private int points;

    public Trash(int id, String trashName, int points) {
        this.id = id;
        this.trashName = trashName;
        this.points = points;
    }

    public Trash() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrashName() {
        return trashName;
    }

    public void setTrashName(String trashName) {
        this.trashName = trashName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Trash{" +
                "id=" + id +
                ", trashName='" + trashName + '\'' +
                ", points=" + points +
                '}';
    }
}
