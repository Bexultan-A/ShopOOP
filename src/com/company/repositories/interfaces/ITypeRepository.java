package com.company.repositories.interfaces;

import com.company.entities.Clothing;
import com.company.entities.Type;

import java.util.List;

public interface ITypeRepository {
    List<Clothing> getClothesByType();
    Type getAllTypes();
}
