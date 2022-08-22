package com.chris.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.chris.ecommerce.Model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
