package com.chris.ecommerce.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addressId")
	private int addressId;
	private String city;
	private String state;
	private String street;
	private String zipcode;
	private String country;
	private String apartmentNumber;
	
	
}
