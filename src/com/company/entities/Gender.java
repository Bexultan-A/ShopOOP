package com.company.entities;

public class Gender extends Style{
    String genderName;

    public Gender(String shopName, String seasonName, String styleName, String genderName) {
        super(shopName, seasonName, styleName);
        this.genderName = genderName;
    }
    public Gender(){}

    public String getGender() {
        return genderName;
    }

    public void setGender(String genderName) {
        this.genderName = genderName;
    }
}
