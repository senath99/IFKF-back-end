package com.ITP.IFKFbackend.service.impl;

import com.ITP.IFKFbackend.service.CartService;
import com.ITP.IFKFbackend.model.Cart;
import com.ITP.IFKFbackend.model.Product;
import com.ITP.IFKFbackend.repository.CartRepository;
import com.ITP.IFKFbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Cart addedToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    //get all the details of cart
    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteProduct(String id) {
        cartRepository.deleteProduct(id);
    }

    @Override
    public Cart avoidrepeat(String id) {
        cartRepository.avoidrepeatItems(id);
        return null;
    }

    @Override
    public void clearCart(String id) {
        cartRepository.clearCart(id);
    }

//    @Override
//    public void deleteProduct(long  id) {
//        String t= String.valueOf(id);
//        cartRepository.deleteById(t);
//
//    }


    @Override
    public List<Product> getAlProducts(String c001) {
        List<Object[]> ob = productRepository.getAllBy("C001");
        List<Product> item = new ArrayList<>();


        for (Object s2[] : ob) {
            Product product = new Product();

            product.setId(s2[0].toString());
            product.setBrand(s2[1].toString());
            product.setDescription(s2[2].toString());
            product.setPicture((byte[]) s2[3]);
            product.setPrice(Double.parseDouble(s2[4].toString()));
            product.setProductname(s2[5].toString());
            product.setQty(Integer.parseInt(s2[6].toString()));



            item.add(product);

        }
        return item;
    }


}
