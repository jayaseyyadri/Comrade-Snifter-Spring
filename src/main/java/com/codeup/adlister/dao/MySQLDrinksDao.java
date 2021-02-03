package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDrinksDao implements Drinks {
    private Connection connection = null;

    public MySQLDrinksDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Drink> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM comrade_snifter_db.drinks");
            ResultSet rs = stmt.executeQuery();
            return createDrinksFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all drinks.", e);
        }
    }

    @Override
    public Long insert(Drink drink) {
        try {
            String insertQuery = "INSERT INTO comrade_snifter_db.drinks(user_id, name, instructions, ingredients, image) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, drink.getUserId());
            stmt.setString(2, drink.getName());
            stmt.setString(3, drink.getInstructions());
            stmt.setString(4, drink.getIngredients());
            stmt.setString(5, drink.getImage());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new drink.", e);
        }
    }

    private Drink extractDrink(ResultSet rs) throws SQLException {
        return new Drink(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("name"),
            rs.getString("instructions"),
            rs.getString("ingredients"),
            rs.getString("image")
        );
    }

    private List<Drink> createDrinksFromResults(ResultSet rs) throws SQLException {
        List<Drink> drinks = new ArrayList<>();
        while (rs.next()) {
            drinks.add(extractDrink(rs));
        }
        return drinks;
    }

     public Drink getDrink(long drinkId) {
        PreparedStatement stmt = null;
        String sqlQuery = "SELECT * FROM comrade_snifter_db.drinks WHERE id = ?";

        try {
            stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, drinkId);

            stmt.executeQuery();

            ResultSet rs = stmt.getResultSet();

            rs.next();

            Drink drink = new Drink(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("name"),
            rs.getString("instructions"),
            rs.getString("ingredients"),
            rs.getString("image")
            );
            return drink;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    @Override
    public List<Drink> getUsersDrinks(long userId) {
        PreparedStatement stmt = null;
        String sqlQuery = "SELECT * FROM comrade_snifter_db.drinks WHERE user_id = ?";
        List<Drink> drinks = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, userId);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Drink drink = new Drink(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("name"),
            rs.getString("instructions"),
            rs.getString("ingredients"),
            rs.getString("image")
            );
                drinks.add(drink);
            }
            return drinks;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
}
