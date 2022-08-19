package com.chris.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.chris.ecommerce.Model.CartItem;
import com.chris.ecommerce.Model.Product;
import com.chris.ecommerce.Model.User;
import com.chris.ecommerce.Repo.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTest {

	@Autowired

	private CartItemRepository cartRepo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testAddOneCartItem() {
		Product product = entityManager.find(Product.class, 2);
		User user = entityManager.find(User.class, 8);

		CartItem newItem = new CartItem();
		newItem.setUser(user);
		newItem.setProduct(product);
		newItem.setQuantity(2);

		CartItem savedCartItem = cartRepo.save(newItem);

		assertTrue(savedCartItem.getId() > 0);

	}
	
	@Test
	public void testGetCartItemsByUser() {
		User user = new User();
		user.setId(8);
		
		List<CartItem> 	cartItems = cartRepo.findByUser(user);
		
		assertEquals(1, cartItems.size());
	}

}
