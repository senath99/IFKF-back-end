package com.ITP.IFKFbackend.service.impl;

import com.ITP.IFKFbackend.service.OrderService;
import com.ITP.IFKFbackend.model.Order_List;
import com.ITP.IFKFbackend.model.Product;
import com.ITP.IFKFbackend.repository.OrderRepository;
import com.ITP.IFKFbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Order_List addOrder(Order_List order) {

        Product product = productRepository.findById(order.getProduct_id()).get();
        // when the order is purchursed it auto change in the product_table
        product.setQty(product.getQty()-Integer.parseInt(order.getQty()));
        //save updated data in order
        productRepository.save(product);
        //save data in order list
        return orderRepository.save(order);
    }

    @Override
    public List<Order_List> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteOrder(id);
    }
}
