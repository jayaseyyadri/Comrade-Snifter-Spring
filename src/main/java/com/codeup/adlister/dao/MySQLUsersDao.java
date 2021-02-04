package com.codeup.adlister.dao;

import com.codeup.adlister.models.Drink;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection= null;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM comrade_snifter_db.users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO comrade_snifter_db.users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("image")
        );
    }

    private User extractUserPublicInfo(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getString("username"),
                rs.getString("image")
        );
    }

    public User getUser(long userId) {
        PreparedStatement stmt = null;
        String sqlQuery = "SELECT * FROM comrade_snifter_db.users WHERE id = ?";

        try {
            stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, userId);

            stmt.executeQuery();

            ResultSet rs = stmt.getResultSet();

            rs.next();

            User user = new User(
                    rs.getString("username"),
                    rs.getString("image"),
                    makeList(rs.getString("created_drinks")),
                    makeList(rs.getString("liked_drinks"))
            );
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    @Override
    public boolean isAdmin(long userId) {
        String query = "SELECT is_admin FROM comrade_snifter_db.users where id = ?";
        int thisId = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stm.setLong(1, userId);
            stm.executeQuery();
            ResultSet rs = stm.getResultSet();
            rs.next();
            thisId = (int) rs.getLong("is_admin");

        } catch (SQLException e) {
            throw new RuntimeException("Error validating user", e);
        }
        return thisId == 1;
    }


    // view all users
    public List<User> viewUsers() {
        PreparedStatement stmt = null;
        String query = "Select username,id from comrade_snifter_db.users";
        List<User> usersList = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("username")
                );
                usersList.add(user);
            }
            return usersList;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

    }

    @Override
    public List<String> currentUsernames(){
        List<String> allCurrentUserNames = new ArrayList<>();

        String query = "SELECT username FROM comrade_snifter_db.users";

        try{

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            while(rs.next()){
                allCurrentUserNames.add(
                  rs.getString("username")
                );
            }

        } catch (SQLException e){
            throw new RuntimeException("Error retrieving current user list", e);
        }

        return allCurrentUserNames;
    }

    @Override
    public User getDrinkCreator(long drinkId){
        Drink thisDrink = DaoFactory.getDrinksDao().getDrink(drinkId);
        String query = "SELECT * from comrade_snifter_db.users where id  = ?";

        try{

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, thisDrink.getUserId());
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            return extractUserPublicInfo(rs);

        } catch (SQLException e){
            throw new RuntimeException("Error finding creator for this drink", e);
        }

    }





    //    public Long likeDrink(long drinkILikeId, long currentUserId){
//        String query = "Select liked_drinks from  users where id = ?";
//        String insertQuery = "UPDATE users SET liked_drinks where id = ?";
//        // going to query the liked drinks and if there are currently liked drinks in the specific user's list
//        //
//    }
//
    private static List<Long> makeList(String ids) {
        List<Long> idList = new ArrayList<>();
        String[] list = ids.split(" ");
        for (String s : list) {
            idList.add(Long.parseLong(s));
        }


        return idList;
    }
}
