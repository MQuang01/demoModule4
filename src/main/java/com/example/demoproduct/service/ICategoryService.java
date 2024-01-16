package com.example.demoproduct.service;

import com.example.demoproduct.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);
}
