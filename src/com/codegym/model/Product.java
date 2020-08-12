package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String price;
    private String number;
    private String color;
    private String description;
    private String category;

    public Product(int id, String name, String price, String number, String color, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product() {
    }

    public Product(String name, String price, String number, String color, String description, String category) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String  getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.description = description;
    }
}