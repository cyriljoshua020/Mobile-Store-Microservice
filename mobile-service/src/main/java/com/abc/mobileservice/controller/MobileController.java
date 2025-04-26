package com.abc.mobileservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.abc.mobileservice.entity.Mobile;
import com.abc.mobileservice.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
    private Environment env;
	
	@Autowired
	private MobileService mservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MobileController.class);
	
	@PostMapping("/save")
	public ResponseEntity<Mobile> addMobile(@RequestBody Mobile mobile) {
		mservice.saveMobile(mobile);
		ResponseEntity<Mobile> res = new ResponseEntity<>(mobile,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/{mobileid}")
	public ResponseEntity<Mobile> fetchMobileDetails(@PathVariable int mobileid) {
		Mobile mobile = mservice.getMobileById(mobileid);
		ResponseEntity<Mobile> res = new ResponseEntity<>(mobile,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Mobile>> fetchAllMobiles(){
		
		logger.info("MobileController : fetchAllMobiles started.");
		
		List<Mobile> mobiles = mservice.getAllMobiles();
		ResponseEntity<List<Mobile>> res = new ResponseEntity<>(mobiles,HttpStatus.OK);
		
		logger.info("MobileController : fetchAllMobiles ended with status code:" +HttpStatus.OK);
		
		return res;
	}
	
}

