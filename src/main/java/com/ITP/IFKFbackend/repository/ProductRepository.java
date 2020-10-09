package com.ITP.IFKFbackend.repository;


import com.ITP.IFKFbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

//    @Query(value = "select p.id,p.productname,p.brand,p.catogeory,p.description,p.picture,p.price,p.qty " +
//            "from Cart c ,Product p " +
//            "where  c.product.id = p.id and c.customer.custId = ?1")
//    List<Product> getAllBy(String id);

    @Query(value = "select p.id,p.brand,p.description,p.picture,p.price,p.productname ,c.cid " +
            "from cart c ,product p " +
            "where p.id=c.product_id and c.customer_cust_id = :id ", nativeQuery = true)
    List<Object[]> getAllBy(@Param("id") String id);


    @Query(value = "select p.id,p.brand,p.description,p.picture,p.price,p.productname,p.catogeory,p.qty " +
            "from Product p " +
            "where p.id=:keyword or p.productname=:keyword  or p.brand=:keyword or p.brand like :keyword% or  p.productname LIKE :keyword%" , nativeQuery = true)
    List<Product> search(@Param("keyword") String productname);


}
