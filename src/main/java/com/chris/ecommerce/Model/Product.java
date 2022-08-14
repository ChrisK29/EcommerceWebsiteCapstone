package com.chris.ecommerce.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private ProductCategory category;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "weight")
	private double weight;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "image")
	private String image;
	@Column(name = "category")
	private String categoryName;

}
