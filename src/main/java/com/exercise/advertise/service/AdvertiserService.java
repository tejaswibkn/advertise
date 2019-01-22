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

	public ResponseEntity<String> create(Advertiser advertiser) {
		ResponseEntity<String> response = null;
		try {
			advertiserRepository.insert(advertiser);
			response = new ResponseEntity<String>(gson.toJson(commonUtils.successResponse()), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			response = commonUtils.errorMessage();
		}
		return response;
	}
	
	public ResponseEntity<String> deleteById(Integer id) {
		ResponseEntity<String> response = null;
		try {
			int deleteAdvertiserById = advertiserRepository.deleteAdvertiserById(id);
			if (deleteAdvertiserById == 1) {
				response = new ResponseEntity<String>(gson.toJson(commonUtils.successResponse()), HttpStatus.OK);
			} else {
				response = commonUtils.userNotFound();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = commonUtils.errorMessage();
		}
		return response;
	}


	public ResponseEntity<String> update(Advertiser advertiser) {
		ResponseEntity<String> response = null;
		try {
			int updateAdvertiser = advertiserRepository.updateAdvertiser(advertiser);
			if (updateAdvertiser == 1) {
				response = new ResponseEntity<String>(gson.toJson(commonUtils.successResponse()), HttpStatus.OK);
			} else {
				response = commonUtils.userNotFound();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = commonUtils.errorMessage();
		}
		return response;
	}

	public ResponseEntity<String> makeTransaction(Integer id) {
		ResponseEntity<String> response = null;
		try {
			Advertiser advertiserById = advertiserRepository.getAdvertiserById(id);
			boolean present = Optional.ofNullable(advertiserById).isPresent();
			if (present) {
				if (advertiserById.getAdvertiserCreditLimit() > minLimit) {
					long remaingBal = advertiserById.getAdvertiserCreditLimit() - minLimit;
					advertiserById.setAdvertiserCreditLimit(remaingBal);
					advertiserRepository.updateAdvertiser(advertiserById);
					response = new ResponseEntity<String>(gson.toJson(commonUtils.successResponse()), HttpStatus.OK);
				} else {
					ErrorResponse errorResponse = commonUtils.errorResponse(HttpStatus.BAD_REQUEST.toString(),
							"Insufficent balance");
					response = new ResponseEntity<>(gson.toJson(errorResponse), HttpStatus.BAD_REQUEST);
				}
			} else {
				response = commonUtils.userNotFound();
			}
		} catch (Exception e) {
			response = commonUtils.errorMessage();
		}
		return response;
	}
}
