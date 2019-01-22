package com.exercise.advertise.utils;

import lombok.Data;

@Data
public class SuccessResponse {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
