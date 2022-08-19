package com.chris.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.ecommerce.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
