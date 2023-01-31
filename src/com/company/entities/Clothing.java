package com.company.entities;

public class Clothing extends Type{
    int id;
    String name;
    Double price;
    String color;
    int amount;

    public Clothing(String shopName, String seasonName, String styleName, String genderName, String ageName, String typeName, String name, Double price, String color, int amount) {
        super(shopName, seasonName, styleName, genderName, ageName, typeName);
        this.name = name;
        this.price = price;
        this.color = color;
        this.amount = amount;
    }

    public Clothing (int id, String name, Double price, String color, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", amount=" + amount +
                '}';
    }
}
