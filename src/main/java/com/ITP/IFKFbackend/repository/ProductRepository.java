package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
