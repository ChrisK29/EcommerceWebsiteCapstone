package com.chris.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chris.ecommerce.Model.User;
import com.chris.ecommerce.Repo.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repo;

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showSignUpForm(Model model) { 
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  // Password automatically encrypts when user registers
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);

		return "register_success";

	}
	
	@GetMapping("/users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();               
		model.addAttribute("listUsers", listUsers);
		return "users";

	}

}
