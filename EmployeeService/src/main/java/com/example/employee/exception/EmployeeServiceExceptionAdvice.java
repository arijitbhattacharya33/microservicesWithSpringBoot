package com.example.employee.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeServiceExceptionAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity handle(EmployeeNotFoundException e) {
		JSONObject obj = new JSONObject();
		obj.put("exception", e.getMessage());
		return new ResponseEntity<>(obj.toString(), null, HttpStatus.NOT_FOUND);
	}
}
