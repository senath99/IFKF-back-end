package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface CartRepository extends JpaRepository<Cart,String> {

    @Modifying
    @Transactional
    @Query(value = "DELETE from cart where cid=?1 ",nativeQuery = true)
    void deleteProduct(String id);



}

