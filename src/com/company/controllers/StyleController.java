package com.company.controllers;

import com.company.entities.Clothing;
import com.company.repositories.ClothesRepository;
import com.company.repositories.interfaces.IStyleRepository;

import java.util.List;

public class StyleController {
    private final IStyleRepository repo;

    public StyleController(IStyleRepository repo) {
        this.repo = repo;
    }

    public void getClothesByStyle(String styleName) {
        List<Clothing> clothes = repo.getClothesByStyle(styleName);
        System.out.printf("%-10s%-15s%-15s%-15s%-10s%n", "id", "name", "price", "color", "amount");
        for (Clothing clothing:clothes) {
            System.out.printf("%-10s", clothing.getId());
            System.out.printf("%-15s", clothing.getName());
            System.out.printf("%-15s", clothing.getPrice());
            System.out.printf("%-15s", clothing.getColor());
            System.out.printf("%-10s", clothing.getAmount());
            System.out.println();
        }
    }
}
