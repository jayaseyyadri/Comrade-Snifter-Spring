package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
            rs.getString("image"),
            rs.getInt("votes")
        );
    }

    private List<Drink> createDrinksFromResults(ResultSet rs) throws SQLException {
        List<Drink> drinks = new ArrayList<>();
        while (rs.next()) {
            drinks.add(extractDrink(rs));
        }
        return drinks;
    }

    @Override
    public List<Drink> searchDrinks(String search) {
        PreparedStatement stmt = null;
        String sqlQuery = "SELECT * FROM comrade_snifter_db.drinks WHERE name LIKE (?)";
        List<Drink> drinks = new ArrayList<>();
        String userInput = '%' + search + '%';
        try {
            stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userInput);

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
            };


            return drinks;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
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
            throw new RuntimeException("Error retrieving drink.", e);
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
            while (rs.next()) {
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

    @Override
    public void delete(int id){
        try{
            String deleteQuery = "Delete from comrade_snifter_db.drinks where id = ?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e){
            throw new RuntimeException("Error deleting ad", e);
        }
    }

    @Override
    public void deleteDrinkCategories(int id){
        try{
            String deleteQuery = "Delete from comrade_snifter_db.category where alcohol_id = ?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e){
            throw new RuntimeException("Error deleting ad", e);
        }
    }

    @Override
    public void edit(int id, Drink newDrink){
        try{
            String editQuery = "Update comrade_snifter_db.drinks Set name = ?, instructions = ?, ingredients = ?, image = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(editQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newDrink.getName());
            statement.setString(2, newDrink.getInstructions());
            statement.setString(3, newDrink.getIngredients());
            statement.setString(4, newDrink.getImage());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error editing ad", e);
        }

    }

    @Override
    public void updateThisDrinksVotes(int drinkVotes, long drinkIdToUpdate){
        String query = "UPDATE comrade_snifter_db.drinks set votes = ? where id = ?";

        try {

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, drinkVotes);
            statement.setLong(2, drinkIdToUpdate);
            statement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error voting on drink", e);
        }
    }






    @Override
    public int getDrinkVotes(long id){
        String query = "SELECT votes from comrade_snifter_db.drinks where id = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            rs.next();
            return rs.getInt("votes");

        } catch (SQLException e){
            throw new RuntimeException("Error retrieving votes", e);
        }
    }


    @Override
    public List<Drink> getAllByCategory(String category){
        String query = "SELECT * FROM comrade_snifter_db.drinks where id IN ( select alcohol_id from comrade_snifter_db.category where liquor_type in ( select id from comrade_snifter_db.drink_Category where drink_Category.name = ?))";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            return createDrinksFromResults(rs);

        } catch (SQLException e){
            throw new RuntimeException("Unable to find drinks for this category", e);
        }
    }

    @Override
    public void giveDrinkACategory(long id, int categoryId){
        System.out.println(id);
        String query = "insert into comrade_snifter_db.category(alcohol_id, liquor_type) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            statement.setInt(2, categoryId);
            statement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error adding category to this drink", e);
        }
    }

    @Override
    public int getCategoryId(String name){
        String query = "select id from comrade_snifter_db.drink_Category where name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            rs.next();
            return rs.getInt("id");

        } catch (SQLException e){
            throw new RuntimeException("Error finding category id", e);
        }
    }

    @Override
    public long getDrinkIdByName(String name){
        String query = "SELECT id from comrade_snifter_db.drinks where name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            rs.next();
            return rs.getLong("id");

        } catch (SQLException e){
            throw new RuntimeException("Error finding drink id by name", e);
        }
    }

}
