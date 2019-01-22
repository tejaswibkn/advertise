package com.exercise.advertise;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercise.advertise.entity.Advertiser;
import com.exercise.advertise.service.AdvertiserService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertiseApplicationTests {

	@Mock
	AdvertiserService service;
	
	Gson gson = new Gson();
	
	@Test
	public void getAdvertiserById() {
		Advertiser advertiser = new Advertiser();
		advertiser.setAdvertiserName("tejas");
		when(service.findById(Mockito.any())).thenReturn(new ResponseEntity<>(gson.toJson(advertiser),HttpStatus.CREATED));
		ResponseEntity<String> findById = service.findById(1);
		assertEquals(gson.toJson(advertiser), findById.getBody());
	}
	
	
}
