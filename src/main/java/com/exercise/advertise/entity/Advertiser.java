package com.exercise.advertise.entity;


import lombok.Data;

@Data
public class Advertiser {
	
	private long id;
	
	private String advertiserName;
	
	private String advertiserContactName;
	
	private long advertiserCreditLimit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getAdvertiserContactName() {
		return advertiserContactName;
	}

	public void setAdvertiserContactName(String advertiserContactName) {
		this.advertiserContactName = advertiserContactName;
	}

	public long getAdvertiserCreditLimit() {
		return advertiserCreditLimit;
	}

	public void setAdvertiserCreditLimit(long advertiserCreditLimit) {
		this.advertiserCreditLimit = advertiserCreditLimit;
	}
	
	
}
