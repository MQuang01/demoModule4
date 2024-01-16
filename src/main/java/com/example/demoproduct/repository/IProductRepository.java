package com.example.demoproduct.repository;

import com.example.demoproduct.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();
}
