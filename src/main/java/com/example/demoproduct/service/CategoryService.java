package com.example.demoproduct.service;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.getCategories();
    }

    @Override
    public Category findById(int id) {
        for (Category category : iCategoryRepository.getCategories()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
