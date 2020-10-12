package com.ITP.IFKFbackend.service;

import com.ITP.IFKFbackend.model.Cart;
import com.ITP.IFKFbackend.model.Customer;
import com.ITP.IFKFbackend.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CartService {
    Cart addedToCart(Cart cart);

    //get cart details from cart table
    List<Cart> getAll();
    void deleteProduct(String id);
    Cart avoidrepeat(String id);
    void clearCart(String id);
    List<Product> getAlProducts(String C001);
    //
    List<Product> getAlProductsbyuser(String id1);
    Customer addtoTable(Customer cust);


}
