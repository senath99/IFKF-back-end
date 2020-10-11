package com.ITP.IFKFbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
	
    @Id
    private String custId;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Cart> cart;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        for (Cart c : cart
        ) {
            c.setCustomer(this);
        }
        this.cart = cart;
    }
}
