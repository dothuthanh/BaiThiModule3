package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String price;
    private String number;
    private String color;
    private String discerption;

    public Product(){

    }

    public Product(int id,String name, String price, String number, String color, String discerption) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.discerption = discerption;
    }

    public Product( String name, String price, String number, String color, String discerption) {
    }

    public Product(int id, String name, String number, String color, String discerption) {
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
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

    public String getDiscerption() {
        return discerption;
    }

    public void setDiscerption(String discerption) {
        this.discerption = discerption;
    }
}