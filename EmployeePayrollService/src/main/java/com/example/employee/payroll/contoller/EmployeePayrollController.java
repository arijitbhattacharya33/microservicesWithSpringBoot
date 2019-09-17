package com.example.employee.payroll.contoller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.payroll.model.EmployeePayroll;

@RestController
@RequestMapping(value = "/api")
public class EmployeePayrollController {

	@RequestMapping(value = "/payroll/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<EmployeePayroll> getEmployeePayrollData(@PathVariable("employeeId") Integer employeeId)
			throws Exception {
		try {
			System.out.println("Employee Id:" + employeeId);
			if (employeeId == 704481) {
				EmployeePayroll payroll = new EmployeePayroll();
				payroll.setEmployeeId(704481);
				payroll.setSalary(1200.56);
				payroll.setCurrency("INR");

				return new ResponseEntity<EmployeePayroll>(payroll, HttpStatus.OK);
			} else {
				throw new Exception("No Data Found");
			}
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
