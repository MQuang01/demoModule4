package com.example.demoproduct.repository;

import com.example.demoproduct.model.Category;
import com.example.demoproduct.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final ICategoryRepository iCategoryRepository;

    private List<Product> products = new ArrayList<>();
    public ProductRepository(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
        List<Category> categories = getCategories();
        products.add(new Product(1, "Tivi", "24inch", 1000000, categories.get(0)));
        products.add(new Product(2, "ModemWifi", "15inch", 2000000, categories.get(1)));
        products.add(new Product(3, "Laptop", "14inch", 3000000, categories.get(0)));
        products.add(new Product(4, "PC", "pro", 4000000, categories.get(0)));
        products.add(new Product(5, "Cap Quang", "20m", 5000000, categories.get(1)));
        products.add(new Product(6, "11promax", "hang dat tien", 1000000, categories.get(0)));
        products.add(new Product(7, "11pro", "hang dat tien", 1000000, categories.get(0)));
        products.add(new Product(8, "11", "hang dat tien", 1000000, categories.get(0)));
        products.add(new Product(9, "10", "hang dat tien", 1000000, categories.get(0)));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
    public List<Category> getCategories() { return  iCategoryRepository.getCategories();}
}
