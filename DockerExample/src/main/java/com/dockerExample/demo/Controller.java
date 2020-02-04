package com.dockerExample.demo;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/api/docker/test", method = RequestMethod.GET)
	public ResponseEntity<String> getEmployeePayrollData()throws Exception {
		try {
			return new ResponseEntity<String>("Docker container is working", null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			throw e;
		}
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity handle(Exception e) {
		System.out.println("exception..");
		JSONObject obj = new JSONObject();
		obj.put("exception", e.getMessage());
		return new ResponseEntity<>(obj.toString(), null, HttpStatus.NOT_FOUND);
	}
}
