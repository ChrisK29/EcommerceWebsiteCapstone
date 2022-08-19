package com.chris.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.ecommerce.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
