package com.chris.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.ecommerce.Model.CartItem;
import com.chris.ecommerce.Model.User;
import com.chris.ecommerce.Repo.CartItemRepository;

@Service

public class ShoppingCartServices {

	@Autowired
	private CartItemRepository cartRepo;

	public List<CartItem> listCartItems(User user) {
		return cartRepo.findByUser(user);

	}
}
