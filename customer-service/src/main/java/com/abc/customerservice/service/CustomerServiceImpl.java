package com.abc.customerservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.exception.ResourceNotFoundException;
import com.abc.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository crepo;
	

	@Override
	public Customer saveCustomer(Customer customer) {
				
		customer =  crepo.save(customer);
		
		return customer;
	}

	@Override
	public Customer getCustomerById(int customerid) {

		Optional<Customer> optionalCustomer = crepo.findById(customerid);

		if (optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not existing with id: " + customerid);
		}
		Customer cus = optionalCustomer.get();
		return cus;
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> cus = crepo.findAll();
		return cus;
	}

}

