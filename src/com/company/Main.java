package com.company;

import com.company.controllers.ClothesController;
import com.company.controllers.StyleController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.ClothesRepository;
import com.company.repositories.StyleRepository;
import com.company.repositories.interfaces.IClothesRepository;
import com.company.repositories.interfaces.IStyleRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IClothesRepository clothesRepo = new ClothesRepository(db);
        IStyleRepository styleRepo = new StyleRepository(db);
        ClothesController clothesController = new ClothesController(clothesRepo);
        StyleController styleController = new StyleController(styleRepo);
        Shop shop = new Shop(clothesController, styleController);
        shop.Start();
    }
}