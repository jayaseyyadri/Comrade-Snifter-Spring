package com.codeup.adlister.dao;

public class DaoFactory {
    private static Drinks drinksDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Drinks getDrinksDao() {
        if (drinksDao == null) {
            drinksDao = new MySQLDrinksDao(config);
        }
        return drinksDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
