package com.exercise.advertise.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exercise.advertise.entity.Advertiser;
import com.exercise.advertise.repository.AdvertiserRepository;
import com.exercise.advertise.utils.CommonUtils;
import com.exercise.advertise.utils.ErrorResponse;
import com.google.gson.Gson;

@Service
public class AdvertiserService {

	@Value("${credit.limit.fortransaction}")
	long minLimit;

	@Autowired
	AdvertiserRepository advertiserRepository;
	
	@Autowired
	CommonUtils commonUtils;


	@Autowired
	Gson gson;

	
	public ResponseEntity<String> findById(Integer id) {
		ResponseEntity<String> response = null;
		try {
			Advertiser advertiserById = advertiserRepository.getAdvertiserById(id);
			boolean present = Optional.ofNullable(advertiserById).isPresent();
			if (present) {
				response = new ResponseEntity<>(gson.toJson(advertiserById), HttpStatus.OK);
			} else {
				response = commonUtils.userNotFound();
			}
		} catch (Exception e) {
			response = commonUtils.errorMessage();
		}
		return response;
	}

	

}
