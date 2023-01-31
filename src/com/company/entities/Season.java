package com.company.entities;

public class Season extends ClothesShop{
    String seasonName;

    public Season(String shopName, String seasonName) {
        super(shopName);
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Season(String shopName) {
        super(shopName);
    }
    public Season() {}
}
