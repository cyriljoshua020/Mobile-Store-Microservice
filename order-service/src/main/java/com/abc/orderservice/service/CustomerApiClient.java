package com.abc.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.orderservice.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "CUSTOMER-SERVICE")
@CircuitBreaker(name = "customerApi", fallbackMethod = "getCustomerDetailsFallBack")
public interface CustomerApiClient {
	
	@GetMapping("/customer/{customerid}")
	Customer getCustomerDetails(@PathVariable int customerid);
	
	default Customer getCustomerDetailsFallBack(Throwable t) {
		
		return new Customer();
	}
}
