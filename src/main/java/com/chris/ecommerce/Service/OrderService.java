package com.chris.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chris.ecommerce.Model.Order;
import com.chris.ecommerce.Model.Product;
import com.chris.ecommerce.Repo.OrderRepository;
import com.chris.ecommerce.Repo.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	public Order getOrderById(Integer id) {
		return orderRepo.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+id) );
	}
	
	public void addOrder(Order order) {
		orderRepo.save(order);
	}
	
	public Order updateOrder(Order order) {
		orderRepo
		.findById(order.getOrderId())
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+order.getOrderId()) );
	return orderRepo.save(order);
	}
	
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}
	
	public void addProductToOrder(Integer orderId, Integer productId) throws Exception {
		Order order = orderRepo.findById(orderId)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found with id : "+orderId));
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found with id : "+productId));
		order.getProduct().add(product);
		product.getOrder().add(order);
		orderRepo.save(order);
		productRepo.save(product);
	}
	
}