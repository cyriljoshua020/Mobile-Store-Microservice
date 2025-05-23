package com.abc.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.orderservice.model.Mobile;

@FeignClient(value = "MOBILE-SERVICE")
public interface MobileApiClient {
	
	@GetMapping("/mobile/{mobileid}")
	Mobile getMobileDetails(@PathVariable int mobileid);
	
	
}
