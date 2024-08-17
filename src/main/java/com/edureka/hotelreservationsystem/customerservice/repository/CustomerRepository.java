package com.edureka.hotelreservationsystem.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.hotelreservationsystem.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
