package com.exercise.advertise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.advertise.entity.Advertiser;
import com.exercise.advertise.service.AdvertiserService;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value="/advertiser")
public class AdvertiserController {

	@Autowired
	AdvertiserService advertiserService;

	
	@ApiOperation(value = "Get Advertiser", httpMethod = "GET")
	@GetMapping(value="/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAdvertiserById(@PathVariable("id") Integer id) {
		ResponseEntity<String> findById = advertiserService.findById(id);
		return findById;
	}
	
	
	@ApiOperation(value = "Create Advertiser", httpMethod = "POST")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody Advertiser advertiser) {
		ResponseEntity<String> response = advertiserService.create(advertiser);
		return response;
	}
	
	
	@ApiOperation(value = "Delete Advertiser", httpMethod = "DELETE")
	@DeleteMapping(value="/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
		ResponseEntity<String> deleteById = advertiserService.deleteById(id);
		return deleteById;
	}
	
	@ApiOperation(value = "Update Advertiser", httpMethod = "PUT")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update( @RequestBody Advertiser advertiser) {
		ResponseEntity<String> response = advertiserService.update(advertiser);
		return response;
	}
	
	@ApiOperation(value = "To check that advertiser have enough credit for transaction", httpMethod = "GET")
	@GetMapping(value="/avaliablebalance/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAvaliableBalance(@PathVariable("id") Integer id) {
		ResponseEntity<String> makeTransaction = advertiserService.makeTransaction(id);
		return makeTransaction;
	}
	
}
