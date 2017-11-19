package com.helmo.NatAdmin.models;

public class Bird  extends Identifiable{
    private String name;
    private int averageHeigth;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAverageHeigth() {
        return averageHeigth;
    }

    public void setAverageHeigth(int averageHeigth) {
        this.averageHeigth = averageHeigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
