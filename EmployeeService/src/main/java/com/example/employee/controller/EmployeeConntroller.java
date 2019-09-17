package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.model.Employee;

@RestController
@RequestMapping("/api/")
public class EmployeeConntroller {

	@RequestMapping(value = "employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> allEmployees() {

		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setEmployeeId(704481);
		employee.setEmployeeName("Arijit");
		employee.setEmployeeAddress("Masat,Hooghly");
		employeeList.add(employee);
		// return employeeList;
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "employees/exception", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> employeesExceptionTest() {

		try {
		throw new EmployeeNotFoundException("Employee Not Found...");
		//return new ResponseEntity<>(null, null, HttpStatus.OK);
		}catch(Exception e) {
			throw e;
		}
		/*List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setEmployeeId(704481);
		employee.setEmployeeName("Arijit");
		employee.setEmployeeAddress("Masat,Hooghly");
		employeeList.add(employee);
		// return employeeList;
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);*/
	}
}
