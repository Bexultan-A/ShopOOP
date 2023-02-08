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
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-10s| %-15s| %-15s| %-15s| %-10s%n", "id", "name", "price", "color", "amount");
        for (Clothing clothing:clothes) {
            System.out.printf("| %-10s", clothing.getId());
            System.out.printf("| %-15s", clothing.getName());
            System.out.printf("| %-15s", clothing.getPrice());
            System.out.printf("| %-15s", clothing.getColor());
            System.out.printf("| %-10s", clothing.getAmount());
            System.out.println();
        }
    }

    public Clothing addClothingToCart(int id) {
        Clothing clothing = repo.getClothingByID(id);

        System.out.println(clothing.getName() + " has been added to your cart");

        return clothing;
    }
}
