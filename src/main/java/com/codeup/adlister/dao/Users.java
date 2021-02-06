package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;
import java.util.Set;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User getDrinkCreator(long drinkId);
    List<User> viewUsers();
    Set<String> currentUsernames();
    boolean isAdmin(long userId);
    void  updateUserInformation(User user);
    void deleteUser(long userId);
}
