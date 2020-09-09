package com.ITP.IFKFbackend.Service;

import com.ITP.IFKFbackend.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product p);
    void deleteProduct(String id);

    List<Product> getAll();

}
