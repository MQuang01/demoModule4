package com.example.demoproduct.service;

import com.example.demoproduct.model.Product;
import com.example.demoproduct.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository iProductRepository;
    private final ICategoryService iCategoryService;

    public ProductService(IProductRepository iProductRepository, ICategoryService iCategoryService) {
        this.iProductRepository = iProductRepository;
        this.iCategoryService = iCategoryService;
    }

    @Override
    public List<Product> findAll(int page, int size) {
        return iProductRepository.getProducts().subList((page - 1) * size, page * size);
    }

    @Override
    public void save(Product product) {
        product.setCategory(iCategoryService.findById(product.getCategory().getId()));
        iProductRepository.getProducts().add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : iProductRepository.getProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < iProductRepository.getProducts().size(); i++) {
            if (iProductRepository.getProducts().get(i).getId() == product.getId()) {
                product.setCategory(iCategoryService.findById(product.getCategory().getId()));
                iProductRepository.getProducts().set(i, product);
                break;
            }
        }
    }

    @Override
    public void removeById(int id) {
        for (int i = 0; i < iProductRepository.getProducts().size(); i++) {
            if (iProductRepository.getProducts().get(i).getId() == id) {
                iProductRepository.getProducts().remove(i);
                break;
            }
        }
    }

    @Override
    public int getTotalPages(int size) {
        return (int) Math.ceil((double) iProductRepository.getProducts().size() / size);
    }


}
