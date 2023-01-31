package com.company.repositories.interfaces;

import com.company.entities.Age;
import com.company.entities.Clothing;

import java.util.List;

public interface IAgeRepository {
    List<Clothing> getClothesByAge();
    Age getAllAges();
}
