package com.company.entities;

public class Age extends Gender{
    String ageName;

    public Age(String shopName, String seasonName, String styleName, String genderName, String ageName) {
        super(shopName, seasonName, styleName, genderName);
        this.ageName = ageName;
    }

    public Age(){}

    public String getAgeName() {
        return ageName;
    }

    public void setAgeName(String ageName) {
        this.ageName = ageName;
    }
}
