package com.ITP.IFKFbackend.Service.impl;
import com.ITP.IFKFbackend.Service.ProductService;
import com.ITP.IFKFbackend.model.Product;
import com.ITP.IFKFbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getDetails(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product UpdateProduct(Product p) {
        return productRepository.save(p);
    }


}