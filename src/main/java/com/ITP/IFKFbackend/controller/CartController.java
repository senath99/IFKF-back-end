package com.ITP.IFKFbackend.controller;


import com.ITP.IFKFbackend.Service.CartService;
import com.ITP.IFKFbackend.Service.ProductService;
import com.ITP.IFKFbackend.model.Cart;
import com.ITP.IFKFbackend.model.Customer;
import com.ITP.IFKFbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/CartController")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/CartItems/{id}/{customerId}")
    public Cart addedToCart(@PathVariable String id, @PathVariable ("customerId")String CID){

        Cart cart=new Cart();
        Product p = new Product();
        p.setId(id);
        Customer c = new Customer();
        c.setCustId(CID);
        cart.setCustomer(c);
        cart.setProduct(p);
        return cartService.addedToCart(cart);
    }

    //list all the data from cart id eka senathage ekn gann one
    @GetMapping("/GetCartItems")
    public List<Product> getAll(){
        return  cartService.getAlProducts("C001");
    }

    @DeleteMapping("/deleteItem/{id}")
    void deleteProduct(@PathVariable String  id){

        System.out.println(id);
        cartService.deleteProduct(id);

    }






}
