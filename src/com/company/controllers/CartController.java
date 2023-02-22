package com.company.controllers;

import com.company.entities.Clothing;
import com.company.repositories.interfaces.ICartRepository;

public class CartController {
    private final ICartRepository repo;


    public CartController(ICartRepository repo) {
        this.repo = repo;
    }

    public String buyClothes(Clothing clothing) {
        boolean bought = repo.buyClothes(clothing.getId());

        return (bought ? "You have bought " + clothing.getName() : "Sorry, we are out of this clothing");
    }
}
