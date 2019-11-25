package com.customerfarm.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerfarm.springboot.exceptions.CustomerNotFoundException;
import com.customerfarm.springboot.exceptions.FarmNotFoundException;
import com.customerfarm.springboot.model.Customer;
import com.customerfarm.springboot.model.Farm;
import com.customerfarm.springboot.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}



	@GetMapping("/farm/{id}")
	public List<Farm> getCustomerFarm(@PathVariable("id") Long id) throws FarmNotFoundException {

		Optional<Customer> customer = customerRepository.findById(id);

		List<Farm> customerFarms = null;

		try {

			if (!customer.isPresent())
				throw new CustomerNotFoundException();

		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		customerFarms = customer.get().getFarms();

		if (customerFarms == null || customerFarms.isEmpty())
			throw new FarmNotFoundException();

		return customerFarms;
	}

}
