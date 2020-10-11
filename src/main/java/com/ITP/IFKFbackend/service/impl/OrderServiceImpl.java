package com.ITP.IFKFbackend.service.impl;

import com.ITP.IFKFbackend.service.OrderService;
import com.ITP.IFKFbackend.model.Order_List;
import com.ITP.IFKFbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order_List addOrder(Order_List order) {
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
