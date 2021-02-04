package com.codeup.adlister.models;

public class Drink {
    private long id;
    private long userId;
    private String name;
    private String instructions;
    private String ingredients;
    private String image;

    public Drink(){};

    public Drink(long id, long userId, String name, String instructions, String ingredients, String image) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.image = image;
    }

    public Drink(long userId, String name, String instructions, String ingredients, String image) {
        this.userId = userId;
        this.name = name;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
