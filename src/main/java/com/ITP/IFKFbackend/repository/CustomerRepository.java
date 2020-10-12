package com.ITP.IFKFbackend.repository;

import com.ITP.IFKFbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
