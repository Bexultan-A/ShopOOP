package com.company.repositories.interfaces;

import com.company.entities.Clothing;

import java.util.ArrayList;
import java.util.List;

public interface IFilterRepository {
    List<Clothing> getClothesByFilter(ArrayList<String> filters, ArrayList<String> filterName);
}
