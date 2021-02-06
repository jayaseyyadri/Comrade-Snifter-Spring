package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;

import java.util.List;

public interface Drinks {
    List<Drink> all();
    List<Drink> searchDrinks(String search);
    List<Drink> getAllByCategory(String category);
    List<Drink> getUsersDrinks(long user_id);
    Drink getDrink(long drinkId);
    Long insert(Drink drink);
    long getDrinkVotes(long id);
    int getCategoryId(String name);
    long getDrinkIdByName(String name);
    void delete(int id);
    void edit(int id, Drink newDrink);
    void updateThisDrinksVotes(long drinkVotes, long drinkIdToUpdate);
    void giveDrinkACategory(long id, int categoryId);
    void deleteDrinkCategories(int id);
}
