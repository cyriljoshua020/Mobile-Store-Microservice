package com.abc.mobileservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.mobileservice.controller.MobileController;
import com.abc.mobileservice.entity.Mobile;
import com.abc.mobileservice.exception.ResourceNotFoundException;
import com.abc.mobileservice.repository.MobileRepository;
import com.abc.mobileservice.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {
	@Autowired
	private MobileRepository mrepo;
	
	private static final Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);
	
	@Override
	public Mobile saveMobile(Mobile mobile) {
		
		mrepo.save(mobile);
		return mobile;
	}
	
	@Override
	public Mobile getMobileById(int mobileId) {
		Optional<Mobile> optionalMobile = mrepo.findById(mobileId);
		
		if(optionalMobile.isEmpty()) {
			throw new ResourceNotFoundException("Mobile not existing with id: " +mobileId);
		}
		Mobile mobile = optionalMobile.get();
		return mobile;
	}
	@Override
	public List<Mobile> getAllMobiles(){
		logger.info("MobileServiceImpl : getAllMobiles() started.");
		List<Mobile> mobiles = mrepo.findAll();
		logger.info("MobileServiceImpl : getAllMobiles() ended.");
		return mobiles;
	}
}