package com.ITP.IFKFbackend.service;


import com.ITP.IFKFbackend.model.Order_List;
import com.ITP.IFKFbackend.model.Order_List;


import java.util.List;

//@Service
public interface OrderService {

    Order_List addOrder(Order_List order);
    List<Order_List> getAll();
    void deleteOrder(String id);
}

