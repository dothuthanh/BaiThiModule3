package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProduct {
    void insert(Product product);

    void update(Product product);

    Product findById(int id);

    List<Product> findAll();

    void remove(int id);

    List<Product> findByPrice(String price);

    List<Product> searchByName(String name);
}
