package com.chris.ecommerce.Model;

public class Address {
	private int addressId;
	private String city;
	private String state;
	private String street;
	private String zipcode;
	private String country;
	private String apartmentNumber;
	
	public Address() {
		
	}

	public Address(int addressId, String city, String state, String street, String zipcode, String country,
			String apartmentNumber) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.street = street;
		this.zipcode = zipcode;
		this.country = country;
		this.apartmentNumber = apartmentNumber;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	

}
