package com.edureka.hotelreservationsystem.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.hotelreservationsystem.customerservice.entity.Customer;
import com.edureka.hotelreservationsystem.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {		
		return customerRepository.save(customer);
	}

	public Customer getCustomer(Long id) {		
		return customerRepository.findById(id).orElse(null);
	}

}
