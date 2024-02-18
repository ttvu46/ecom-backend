package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.UserEntity;
import com.project.ecommerce.payload.request.CartRequest;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.ProductRepository;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/cart")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addToCart(@RequestBody CartRequest request){
        Integer productId = request.getProductId();
        Integer quantity = request.getQuantity();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() ->  new UsernameNotFoundException("User not found."));

        Product getProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        Optional<Cart> getCart = cartRepository.findByUserAndProduct(user, getProduct);
        Cart cart;

        if(getCart.isEmpty()){
            System.out.println("Cart is emtpy.");

            cart = new Cart();
            cart.setUser(user);
            cart.setProduct(getProduct);
            cart.setQuantity(quantity);
            cartRepository.save(cart);
        }else{
            System.out.println("CART is modified.");
            cart = getCart.get();;
            cart.setQuantity(cart.getQuantity() + quantity);
            cartRepository.save(cart);
        }

        return ResponseEntity.ok("success");
    }

    @GetMapping("/total")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getTotal(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() ->  new UsernameNotFoundException("User not found."));

        List<Cart> carts = cartRepository.findByUser(user);
        Integer total = 0;
        for(Cart cart: carts){
            total += cart.getQuantity();
        }
        return ResponseEntity.ok(total);

    }



}


