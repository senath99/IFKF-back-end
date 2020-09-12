package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,String> {
}
