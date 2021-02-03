package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;

import java.util.List;

public interface Drinks {
    // get a list of all the ads
    List<Drink> all();
    // insert a new ad and return the new ad's id
    Long insert(Drink drink);
    void delete(int id);
    void edit(int id, Drink newDrink);
    Drink getDrink(long drinkId);
}
