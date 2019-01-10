package com.exercise.advertise.entity;


import lombok.Data;

@Data
public class Advertiser {
	
	private long id;
	
	private String advertiserName;
	
	private String advertiserContactName;
	
	private long advertiserCreditLimit;
}
