package com.exercise.advertise.utils;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	String status;

	List<Errors> errors;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

}
