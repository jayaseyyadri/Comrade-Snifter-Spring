package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

import java.util.List;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String image;
    private List<Long> createdDrinksIds;
    private List<Long> likedDrinksIds;

    public User() {}

    public User(String username, String image, List<Long> createdDrinksIds, List<Long> likedDrinksIds) {
        this.username = username;
        this.image = image;
        this.createdDrinksIds = createdDrinksIds;
        this.likedDrinksIds = likedDrinksIds;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
//CREATED NEW CONSTRUCTOR

    public User(long id, String username, String email, String password, String image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username, String image) {
        this.username = username;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Long> getCreatedDrinksIds() {
        return createdDrinksIds;
    }

    public void setCreatedDrinksIds(List<Long> createdDrinksIds) {
        this.createdDrinksIds = createdDrinksIds;
    }

    public List<Long> getLikedDrinksIds() {
        return likedDrinksIds;
    }

    public void setLikedDrinksIds(List<Long> likedDrinksIds) {
        this.likedDrinksIds = likedDrinksIds;
    }
}

