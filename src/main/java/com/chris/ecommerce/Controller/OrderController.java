package com.chris.ecommerce.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.ecommerce.Model.Order;
import com.chris.ecommerce.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/admin/{id}")
	public Order getorder(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/admin")
	public List<Order> getorders() {
		return orderService.getAllOrders();
	}
	
	@PostMapping("/add")
	public void addorder(@RequestBody Order order) {
		orderService.addOrder(order);
	}
	
	@PostMapping("/{orderId}/product/{productId}")
	public void addProductToOrder(@PathVariable Integer orderId, @PathVariable Integer productId) throws Exception {
		orderService.addProductToOrder(orderId, productId);
	}
	
	@PutMapping("/update")
	public void updateorder(@RequestBody Order order) {
		orderService.updateOrder(order);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteorder(@PathVariable Integer id) {
		orderService.deleteOrder(id);
	}
}
