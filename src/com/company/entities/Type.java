package com.company.entities;

public class Type extends Age{
    String typeName;

    public Type(String shopName, String seasonName, String styleName, String genderName, String ageName, String typeName) {
        super(shopName, seasonName, styleName, genderName, ageName);
        this.typeName = typeName;
    }
    public Type(){}

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
