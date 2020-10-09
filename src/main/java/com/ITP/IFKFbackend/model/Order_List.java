package com.ITP.IFKFbackend.model;

import javax.persistence.*;

@Entity
//@Table(name= "orders")
public class Order_List {



//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
//    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

//    @Column(name = "product_id")
    private String product_id;

//    @Column(name = "productname")
    private String productname;

//    @Column(name = "brand")
    private String brand;

//    @Column(name = "email")
    private String email;

//    @Column(name = "descriptions")
    private String descriptions;

//    @Column(name = "Address")
    private String Address;

//    @Column(name = "Total_amont")
    private String Total_amount;

    private String purchase_date;
    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Order_List() {

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    //public String getDescription() {
    //    return description;
    //}

    //public void setDescription(String description) {
    //    this.description = description;
    //}

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(String total_amount) {
        Total_amount = total_amount;
    }
}
