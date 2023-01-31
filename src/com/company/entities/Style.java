package com.company.entities;

public class Style extends Season {
    String styleName;

    public Style(String shopName, String seasonName, String styleName) {
        super(shopName, seasonName);
        this.styleName = styleName;
    }
    public Style(){}

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

}
