package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;
import java.util.Set;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    boolean isAdmin(long userId);
    List<User> viewUsers();
    Set<String> currentUsernames();
    User getDrinkCreator(long drinkId);
}
