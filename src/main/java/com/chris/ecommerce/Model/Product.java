package com.chris.ecommerce.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "weight")
	private double weight;
	@Lob

	@ManyToMany(mappedBy = "product", cascade = { CascadeType.ALL })
	@JsonIgnore
	List<Order> order;
	@ManyToOne()
	@JoinColumn(nullable = false, name = "categoryId")
	private ProductCategory category;

}
