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
        for (Clothing clothing:clothes) {
            System.out.println(clothing.getId() + " " + clothing.getName() + " " + clothing.getPrice() + " " + clothing.getColor() + " " + clothing.getAmount());
        }
    }
}
