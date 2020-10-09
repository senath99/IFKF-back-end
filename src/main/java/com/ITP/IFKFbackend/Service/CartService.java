package com.ITP.IFKFbackend.Service;

import com.ITP.IFKFbackend.model.Cart;
import com.ITP.IFKFbackend.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CartService {
    Cart addedToCart(Cart cart);

    //get cart details from cart table
    List<Cart> getAll();
    void deleteProduct(String id);




    List<Product> getAlProducts(String C001);


}
