package com.company.repositories.interfaces;

import com.company.entities.Clothing;
import com.company.entities.Gender;

import java.util.List;

public interface IGenderRepository {
    List<Clothing> getClothesByGender();
    Gender getAllGenders();
}
