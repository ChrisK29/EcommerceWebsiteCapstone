package com.chris.ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.ecommerce.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
