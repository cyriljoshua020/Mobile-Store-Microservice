package com.abc.customerservice.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.customerservice.entity.Customer;
import com.abc.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
    private Environment env;
	
	@Autowired
	private CustomerService cservice;
	
	@GetMapping("/loadtest")
	public String testLoadBalance() {
		return "Customer Service Running on port:"+env.getProperty("local.server.port");
	}
	
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		cservice.saveCustomer(customer);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	
	@GetMapping("/{customerid}")
	public ResponseEntity<Customer> fetchCustomerDetails(@PathVariable int customerid) {
		
		System.out.println("Customer Service Running on port: " + env.getProperty("server.port"));
		
		Customer cus = cservice.getCustomerById(customerid);
		 
		return new ResponseEntity<>(cus,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> fetchAllMobiles(){
		
		List<Customer> customer = cservice.getAllCustomers();
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}
}
