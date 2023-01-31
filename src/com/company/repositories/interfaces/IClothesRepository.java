package com.company.repositories.interfaces;

import com.company.entities.Clothing;

import java.util.List;

public interface IClothesRepository {
    boolean createClothing(Clothing clothing);
    List<Clothing> getAllClothes();
    Clothing getClothingByID(int id);
    Clothing getClothingByName(String name);
}
