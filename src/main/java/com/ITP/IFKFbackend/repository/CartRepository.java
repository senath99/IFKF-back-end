package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart,String> {

    @Modifying
    @Transactional
    @Query(value = "DELETE from cart where cid=?1 ",nativeQuery = true)
    void deleteProduct(String id);


    @Query(value = "SELECT product_id from cart where product_id=:id ", nativeQuery = true)
    List<Cart>avoidrepeatItems(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE from cart where product_id=:id ",nativeQuery = true)
    void clearCart(@Param("id") String id);
}

