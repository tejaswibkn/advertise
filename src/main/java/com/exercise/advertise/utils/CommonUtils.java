package com.exercise.advertise.utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CommonUtils {

	@Autowired
	Gson gson;
	
	public ErrorResponse errorResponse(String code,String message){
		Errors errors = new Errors();
		errors.setCode(code);
		errors.setMessage(message);
		ArrayList<Errors> arrayList = new ArrayList<Errors>();
		arrayList.add(errors);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("error");
		errorResponse.setErrors(arrayList);
		return errorResponse;
	}

	public ResponseEntity<String> errorMessage() {
		ResponseEntity<String> response;
		ErrorResponse errorResponse = this.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Some Error Occured");
		response = new ResponseEntity<>(gson.toJson(errorResponse), HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
	
	public ResponseEntity<String> userNotFound() {
		ErrorResponse errorResponse = this.errorResponse(HttpStatus.BAD_REQUEST.toString(),
				"User doesn't exists");
		return new ResponseEntity<String>(gson.toJson(errorResponse), HttpStatus.BAD_REQUEST);
	}
	
	public SuccessResponse successResponse(){
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setStatus("Success");
		return successResponse;
	}
}
