package com.chris.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chris.ecommerce.Model.ProductCategory;
import com.chris.ecommerce.Repo.ProductCategoryRepository;



@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository categoryRepo;
	
	public List<ProductCategory> getAllCategory() {
		return categoryRepo.findAll();
	}
	
	public ProductCategory getCategoryById(Integer id) {
		return categoryRepo.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product category not found with id : "+id) );
	}
	
	public void addCategory(ProductCategory category) {
		categoryRepo.save(category);
	}
	
	public ProductCategory updateCategory(ProductCategory category) {
		categoryRepo
			.findById(category.getId())
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product category not found with id : "+category.getId()) );
		return categoryRepo.save(category);
	}
	
	public void deleteCategory(Integer id) {
		categoryRepo.deleteById(id);
	}

}
