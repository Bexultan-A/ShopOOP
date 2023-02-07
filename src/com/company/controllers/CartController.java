package com.company.controllers;

import com.company.entities.Cart;
import com.company.entities.Clothing;
import com.company.repositories.interfaces.ICartRepository;

import java.util.List;

public class CartController {
    private final ICartRepository repo;


    public CartController(ICartRepository repo) {
        this.repo = repo;
    }

    public String buyClothes(Clothing clothing) {
        boolean bought = repo.buyClothes(clothing.getId());

        return (bought ? "You have bought " + clothing.getName() : "Error");
    }
}
