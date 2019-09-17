package com.example.employee.controller;

import org.json.JSONObject;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandelController implements ErrorController {

	@RequestMapping(value="/error")
	public ResponseEntity<String> errorMessage() {
		JSONObject object = new JSONObject();
		String errorMessage = "Error! This is an default error message.";
		object.put("error", errorMessage);
		return new ResponseEntity<String>(object.toString(), HttpStatus.NOT_FOUND);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
