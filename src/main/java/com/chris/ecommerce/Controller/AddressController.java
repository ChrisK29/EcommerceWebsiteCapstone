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

import com.chris.ecommerce.Model.Address;
import com.chris.ecommerce.Service.AddressService;



@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")                //find Address by id
	public Address getaddress(@PathVariable Integer id) {
		return addressService.getAddressById(id);
	}
	
	@GetMapping()             //get all addresses
	public List<Address> getaddresss() {
		return addressService.getAllAddresses();
	}
	
	@PostMapping("/add")                              // add Address           
	public void addaddress(@RequestBody Address address) {
		addressService.addAddress(address);
	}
	
	@PutMapping("/update")                     // update existing Address
	public void updateaddress(@RequestBody Address address) {
		addressService.updateAddress(address);
	}
	
	@DeleteMapping("/delete/{id}")                        //delete Address by id
	public void deleteaddress(@PathVariable Integer id) {
		addressService.deleteAddressById(id);
	}
}