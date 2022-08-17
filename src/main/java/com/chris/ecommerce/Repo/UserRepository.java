package com.chris.ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.ecommerce.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
}
