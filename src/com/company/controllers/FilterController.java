package com.company.controllers;

import com.company.entities.Clothing;
import com.company.repositories.interfaces.IFilterRepository;

import java.util.ArrayList;
import java.util.List;

public class FilterController {
    private final IFilterRepository repo;

    public FilterController(IFilterRepository repo) {
        this.repo = repo;
    }

    public void getClothesByFilter(ArrayList<String> filters, ArrayList<String> filterName) {
        List<Clothing> clothes = repo.getClothesByFilter(filters,filterName);
        for (Clothing clothing:clothes) {
            System.out.println(clothing.getId() + " " + clothing.getName() + " " + clothing.getPrice() + " " + clothing.getColor() + " " + clothing.getAmount());
        }
    }
}
