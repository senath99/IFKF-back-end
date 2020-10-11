package com.ITP.IFKFbackend.controller;

import com.ITP.IFKFbackend.service.OrderService;
import com.ITP.IFKFbackend.model.Order_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.ITP.IFKFbackend.model.Order;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/OrderController")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/Order")
    public Order_List addOrder(@RequestParam("productname") String productname, @RequestParam("id") String id,
                          @RequestParam("brand") String brand, @RequestParam("total") String total,
                          @RequestParam("description") String description, @RequestParam("email") String email,
                          @RequestParam("Address") String Address, @RequestParam("purchase_date") String purchase_date,@RequestParam("Qty")String qty){

        Order_List order=new Order_List();
        //order.setOrder_id(1);
        order.setAddress(Address);
        order.setEmail(email);
        order.setBrand(brand);
        order.setTotal_amount(total);
        order.setDescriptions(description);
        order.setProductname(productname);
        order.setProduct_id(id);
        order.setPurchase_date(purchase_date);
        order.setQty(qty);

       return orderService.addOrder(order);

    }
    @GetMapping("/getAll")
    public List<Order_List> getAll() {
        return orderService.getAll();
    }






    @DeleteMapping("/deleteItem/{id}")
    void deleteOrder(@PathVariable String  id){

        System.out.println(id);
        orderService.deleteOrder(id);

    }

}
