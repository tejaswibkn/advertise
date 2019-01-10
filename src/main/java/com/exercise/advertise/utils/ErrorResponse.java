package com.exercise.advertise.utils;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	String status;
	
	List<Errors> errors;
}
