package com.company;

import com.company.controllers.CartController;
import com.company.controllers.ClothesController;
import com.company.controllers.FilterController;
import com.company.controllers.StyleController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CartRepository;
import com.company.repositories.ClothesRepository;
import com.company.repositories.FilterRepository;
import com.company.repositories.StyleRepository;
import com.company.repositories.interfaces.ICartRepository;
import com.company.repositories.interfaces.IClothesRepository;
import com.company.repositories.interfaces.IFilterRepository;
import com.company.repositories.interfaces.IStyleRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();

        IClothesRepository clothesRepo = new ClothesRepository(db);
        IStyleRepository styleRepo = new StyleRepository(db);
        IFilterRepository filterRepo = new FilterRepository(db);
        ICartRepository cartRepo = new CartRepository(db);

        ClothesController clothesController = new ClothesController(clothesRepo);
        StyleController styleController = new StyleController(styleRepo);
        FilterController filterController = new FilterController(filterRepo);
        CartController cartController = new CartController(cartRepo);

        Shop shop = new Shop(clothesController, styleController, filterController, cartController);
        shop.Start();
    }
}