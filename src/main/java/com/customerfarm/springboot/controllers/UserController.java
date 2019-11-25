package com.customerfarm.springboot.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerfarm.springboot.exceptions.CustomerNotFoundException;
import com.customerfarm.springboot.exceptions.UserNotFoundException;
import com.customerfarm.springboot.model.Customer;
import com.customerfarm.springboot.model.User;
import com.customerfarm.springboot.repositories.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
    
	@GetMapping
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		
		Optional<User> user = userRepository.findById(id);
		
			try {
				
				if(!user.isPresent())
				throw new UserNotFoundException();
				
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
		
		return user.get();
	}
	
	@GetMapping("/{username}")
	public User getUserByName(@PathVariable String username) {
		
		Optional<User> user = userRepository.findByUsername(username);
		
			try {
				
				if(!user.isPresent())
				throw new UserNotFoundException();
				
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
		
		return user.get();
	}
	
	@GetMapping("/customer/{userId}")
	public Customer getCustomerByUser(@PathVariable Long userId) {

		Optional<User> user = userRepository.findById(userId);

		Customer customer = user.get().getCustomer();

		try {

			if (customer == null)
				throw new CustomerNotFoundException();

		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return customer;
	}
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public User login(@RequestBody Map<String, String> credentials) {
		
		User currentUser = null;
		String username = credentials.get("username");
		String password = credentials.get("password");
		
		Optional<User> user = userRepository.findByUsername(username);
		
		System.out.println("Username: " + username + " Password: " + password);
		
		if(user.isPresent() && user.get().getPassword().equals(password)) currentUser = user.get();
		
		return currentUser;
	}

}
