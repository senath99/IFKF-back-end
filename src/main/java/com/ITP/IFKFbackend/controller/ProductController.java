package com.ITP.IFKFbackend.controller;

import com.ITP.IFKFbackend.Service.ProductService;
import com.ITP.IFKFbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/productController")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@RequestParam("productname") String productname, @RequestParam("id") String id,
                              @RequestParam("brand") String brand, @RequestParam("catogeory") String catogeory,
                              @RequestParam("description") String description, @RequestParam("file") MultipartFile file,
                              @RequestParam("qty") String qty, @RequestParam("price") String price) {
        Product p = new Product();
        try {
            p.setProductname(productname);
            p.setId(id);
            p.setBrand(brand);
            p.setCatogeory(catogeory);
            p.setDescription(description);
            p.setPicture(file.getBytes());
            p.setQty(Integer.parseInt(qty));
            p.setPrice(Double.parseDouble(price));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productService.addProduct(p);

    }


    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/deleteItem/{id}")
    void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}




