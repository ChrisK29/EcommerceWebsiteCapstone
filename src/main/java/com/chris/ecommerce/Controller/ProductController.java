package com.chris.ecommerce.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.ecommerce.Model.Product;
import com.chris.ecommerce.Service.ProductService;

@RestController
@CrossOrigin("**")  
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products") // List all products
	public List<Product> list() {
		return service.listAll();
	}

	@GetMapping("/products/{id}") // List products by productId
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); // return HTTP ERROR 404 if productId not found
		}

	}

	@PostMapping("/products") // Add products
	public void add(@RequestBody Product product) {
		service.save(product);

	}

	@PutMapping("/products/{id}")              // Update existing product
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product existProduct = service.get(id);

			service.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // return HTTP ERROR 404 if productId not found
		}

	}
	
	@DeleteMapping("/products/{id}")          // Delete product by productId
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
