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

        if (clothes.size() <= 0 )
            System.out.println("Sorry, there is no such clothes in our Shop");
        else
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
