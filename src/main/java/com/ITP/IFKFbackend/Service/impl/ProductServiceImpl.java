package com.ITP.IFKFbackend.Service.impl;

import com.ITP.IFKFbackend.Service.ProductService;
import com.ITP.IFKFbackend.model.Product;
import com.ITP.IFKFbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}