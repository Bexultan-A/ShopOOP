package com.company.repositories.interfaces;

import com.company.entities.Clothing;
import com.company.entities.Style;

import java.util.List;

public interface IStyleRepository {
    List<Clothing> getClothesByStyle(String styleName);
    Style getAllStyles();
}
