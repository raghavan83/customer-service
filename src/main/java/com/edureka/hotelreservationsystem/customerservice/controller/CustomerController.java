package com.edureka.hotelreservationsystem.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.hotelreservationsystem.customerservice.entity.Customer;
import com.edureka.hotelreservationsystem.customerservice.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
	    return  ResponseEntity.ok(this.customerService.createCustomer(customer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.getCustomer(id));
	}

}
