package com.example.demoproduct.repository;

import com.example.demoproduct.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getCategories();
}
