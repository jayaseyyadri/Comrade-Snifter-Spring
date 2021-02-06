package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;

import java.util.HashMap;
import java.util.List;

public interface Drinks {
    List<Drink> all();
    Long insert(Drink drink);
    void delete(int id);
    void edit(int id, Drink newDrink);
    Drink getDrink(long drinkId);

    List<Drink> getUsersDrinks(long user_id);
    List<Drink> searchDrinks(String search);
    int getDrinkVotes(long id);
    void updateThisDrinksVotes(int drinkVotes, long drinkIdToUpdate);
    List<Drink> getAllByCategory(String category);
    void giveDrinkACategory(long id, int categoryId);
    int getCategoryId(String name);
    long getDrinkIdByName(String name);
}
