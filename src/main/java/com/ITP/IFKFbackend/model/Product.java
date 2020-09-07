package com.ITP.IFKFbackend.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private String id;
    private String productname;
    private String brand;
    private String catogeory;
    private String description;
    @Lob
    @Basic(fetch= FetchType.LAZY)
    private byte[] picture;
    private double price;
    private int qty;
    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCatogeory() {
        return catogeory;
    }

    public void setCatogeory(String catogeory) {
        this.catogeory = catogeory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
