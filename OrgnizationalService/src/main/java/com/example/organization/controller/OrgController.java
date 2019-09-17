package com.example.organization.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.organization.model.Employee;
import com.example.organization.model.EmployeePayroll;
import com.example.organization.model.OrgEmpDetails;

@RestController
@RequestMapping(value = "/api")
public class OrgController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/empDetails")
	public ResponseEntity<List<OrgEmpDetails>> getOrgEmployeeDetails(/*@PathVariable("employeeId") Integer employeeId*/) {
		//ParameterizedTypeReference<List<Employee>> employeeBean = new ParameterizedTypeReference<List<Employee>>() {
		//};

		try {
			List<OrgEmpDetails> listEmpDetails = new ArrayList<OrgEmpDetails>();
			List<Employee> employeeList = restTemplate.exchange("http://EMPLOYEESERVICE/api/employees", HttpMethod.GET,
					null, new ParameterizedTypeReference<List<Employee>>() {
					}).getBody();
			
			employeeList.forEach(employee -> { 
				OrgEmpDetails empDetails = new OrgEmpDetails();
				empDetails.setEmployeeId(employee.getEmployeeId());
				empDetails.setEmployeeName(employee.getEmployeeName());
				empDetails.setEmployeeAddress(employee.getEmployeeAddress());
				EmployeePayroll employeePayroll = restTemplate.getForObject("http://EMPLOYEEPAYROLLSERVICE/api/payroll/"+employee.getEmployeeId(), EmployeePayroll.class);
				empDetails.setEmployeeSalary(employeePayroll.getSalary());
				empDetails.setSalaryCurrency(employeePayroll.getCurrency());
				listEmpDetails.add(empDetails);				
			});
			return new ResponseEntity<List<OrgEmpDetails>>(listEmpDetails, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity handleException(Exception e) {
		JSONObject obj = new JSONObject();
		obj.put("exception", e.getMessage());
		return new ResponseEntity<>(obj.toString(), null, HttpStatus.NOT_FOUND);
	}
}
