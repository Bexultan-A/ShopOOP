package com.company.repositories.interfaces;

import com.company.entities.Clothing;
import com.company.entities.Season;

import java.util.List;

public interface ISeasonRepository {
    List<Clothing> getClothesBySeason();
    Season getAllSeasons();
}
