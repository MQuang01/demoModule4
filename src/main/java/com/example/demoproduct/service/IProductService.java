package com.example.demoproduct.service;

import com.example.demoproduct.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll(int page, int size);

    void save(Product product);

    Product findById(int id);
    void update(Product product);

    void removeById(int id);

    int getTotalPages(int size);
}
