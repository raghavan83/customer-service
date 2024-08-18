package com.edureka.hotelreservationsystem.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.hotelreservationsystem.customerservice.dto.EventMessage;
import com.edureka.hotelreservationsystem.customerservice.entity.Customer;
import com.edureka.hotelreservationsystem.customerservice.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EventPublisher eventPublisher;

	public Customer createCustomer(Customer customer) {
		
		Customer createdCustomer = customerRepository.save(customer);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(createdCustomer);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventMessage eventMessage = new EventMessage();
		eventMessage.setEventType("UserRegistered");
		eventMessage.setEventMessage(jsonString);
		
		this.eventPublisher.publishEvent(eventMessage);
		
		
		return createdCustomer;
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
		
		Customer updatedCustomer = null;
		if (customerRepository.existsById(id)) {
			customer.setId(id); // Ensure the correct ID is set for update
			
			updatedCustomer = customerRepository.save(customer);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = null;
			try {
				jsonString = objectMapper.writeValueAsString(updatedCustomer);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EventMessage eventMessage = new EventMessage();
			eventMessage.setEventType("UserUpdated");
			eventMessage.setEventMessage(jsonString);
			
			this.eventPublisher.publishEvent(eventMessage);
			
			
			return updatedCustomer;
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
