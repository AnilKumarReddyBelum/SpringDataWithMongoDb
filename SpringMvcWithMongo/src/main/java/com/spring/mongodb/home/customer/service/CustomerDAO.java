package com.spring.mongodb.home.customer.service;

import java.util.List;

import com.spring.mongodb.home.customer.model.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> listCustomer();

	void deleteCustomer(Customer customer);

	void updateCustomer(Customer customer);

}
