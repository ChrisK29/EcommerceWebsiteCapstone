package com.chris.ecommerce.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chris.ecommerce.Model.CartItem;
import com.chris.ecommerce.Model.User;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	public List<CartItem> findByUser(User user);
	

}
