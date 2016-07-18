package com.spring.mongodb.home.customer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongodb.home.customer.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private MongoTemplate template;

	public static final String COLLECTION_NAME = "customer";
	public static final String ID="_id";

	@Override

	public void addCustomer(Customer customer) {
		if (!template.collectionExists(Customer.class)) {
			template.createCollection(Customer.class);
		}

		customer.setId(UUID.randomUUID().toString());
		template.insert(customer, COLLECTION_NAME);

	}

	@Override
	public List<Customer> listCustomer() {
		return template.findAll(Customer.class, COLLECTION_NAME);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Query query = new Query(Criteria.where(ID).is(customer.getId()));
		template.remove(query,COLLECTION_NAME);
	}

	@Override
	public void updateCustomer(Customer customer) {
		template.insert(Customer.class, COLLECTION_NAME);
	}

}
