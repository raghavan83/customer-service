package com.edureka.hotelreservationsystem.customerservice.service;

import java.util.List;

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

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
		// Add Logic to post to Kafka topic
		// event UserRegistered
	}

	public Customer updateCustomer(Long id, Customer customer) {
		if (customerRepository.existsById(id)) {
			customer.setId(id); // Ensure the correct ID is set for update
			
			return customerRepository.save(customer);
		} else {
			return null;
		}
		
		// Add Logic to post to Kafka topic
		// event UserUpdated
	}

	public boolean deleteCustomer(Long id) {
		if (customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
