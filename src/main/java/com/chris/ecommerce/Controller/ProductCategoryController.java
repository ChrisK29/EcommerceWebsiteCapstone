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

import com.chris.ecommerce.Model.ProductCategory;
import com.chris.ecommerce.Service.ProductCategoryService;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService categoryService;

	@GetMapping("/{id}")
	public ProductCategory getcategory(@PathVariable Integer id) {
		return categoryService.getCategoryById(id);
	}

	@GetMapping()
	public List<ProductCategory> getcategorys() {
		return categoryService.getAllCategory();
	}

	@PostMapping("/add")
	public void addcategory(@RequestBody ProductCategory category) {
		categoryService.addCategory(category);
	}

	@PutMapping("/update")
	public void updatecategory(@RequestBody ProductCategory category) {
		categoryService.updateCategory(category);
	}

	@DeleteMapping("/delete/{id}")
	public void deletecategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}
}