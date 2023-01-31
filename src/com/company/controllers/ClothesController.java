package com.company.controllers;

import com.company.entities.Clothing;
import com.company.repositories.interfaces.IClothesRepository;
import java.util.List;

public class ClothesController {
    private final IClothesRepository repo;

    public ClothesController(IClothesRepository repo) {
        this.repo = repo;
    }

    public String createClothing(String shopName, String seasonName, String styleName, String genderName, String ageName, String typeName, String name, Double price, String color, int amount) {
        Clothing clothing = new Clothing(shopName, seasonName, styleName, genderName, ageName, typeName, name, price, color, amount);

        boolean created = repo.createClothing(clothing);

        return (created ? "Clothing was created!" : "Clothing creation failed!");
    }

    public void getAllClothes() {
        List<Clothing> clothes = repo.getAllClothes();
        for (Clothing clothing:clothes) {
            System.out.println(clothing.getId() + " " + clothing.getName() + " " + clothing.getPrice() + " " + clothing.getColor() + " " + clothing.getAmount());
        }
    }
}
