package com.ITP.IFKFbackend.Service;

import com.ITP.IFKFbackend.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product p);
    void deleteProduct(String id);
    List<Product> getAll();
    Optional<Product> getDetails(String id);
    Product UpdateProduct(Product p);

}
