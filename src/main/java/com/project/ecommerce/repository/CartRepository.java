package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Product;
import com.project.ecommerce.entity.UserEntity;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(UserEntity user);

    Optional<Cart> findByProduct(Product product);
    Optional<Cart> findByUserAndProduct(UserEntity user, Product product);
}
