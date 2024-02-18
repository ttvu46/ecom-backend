package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public Product getProductById(@PathVariable Integer id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        else{
            throw new RuntimeException("Product Not Found");
        }
    }
}
