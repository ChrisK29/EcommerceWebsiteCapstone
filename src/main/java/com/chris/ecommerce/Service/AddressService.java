package com.chris.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chris.ecommerce.Model.Address;
import com.chris.ecommerce.Repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;

	public List<Address> getAllAddresses() {
		return addressRepo.findAll();
	}

	public Address getAddressById(Integer id) {
		return addressRepo.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id : " + id));
	}

	public void addAddress(Address address) {
		addressRepo.save(address);
	}

	public Address updateAddress(Address address) {
		addressRepo.findById(address.getAddressId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Address not found with id : " + address.getAddressId()));
		return addressRepo.save(address);
	}

	public void deleteAddressById(Integer id) {
		addressRepo.deleteById(id);
	}

}