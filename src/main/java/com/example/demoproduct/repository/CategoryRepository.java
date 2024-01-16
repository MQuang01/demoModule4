package com.example.demoproduct.repository;

import com.example.demoproduct.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {
    private List<Category> categories = new ArrayList<>();
    public CategoryRepository() {
        categories.add(new Category(1, "Thiết bị điện tử"));
        categories.add(new Category(2, "Thiết bị mạng"));
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
