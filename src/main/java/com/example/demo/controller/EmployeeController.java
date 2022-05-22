package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.Employee;
import com.example.demo.responses.EmployeeResponse;
import com.example.demo.responses.StudentResponse;
import com.example.demo.services.EmployeeServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/demo/one/")
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeServices;

	@PutMapping("/update")
	ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeDto dto) {
		return new ResponseEntity<EmployeeResponse>(employeeServices.updateEmplopyee(dto), HttpStatus.OK);
	}
	
	@GetMapping("/page")
	ResponseEntity<EmployeeResponse> getAllByPagination(@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "2") int size){		
		return new ResponseEntity<EmployeeResponse>(employeeServices.getAllByPagination(page,size),HttpStatus.OK);
	}
	
	@PutMapping("/rt")
	ResponseEntity<StudentResponse> getDataByRestTemplate(@RequestBody EmployeeDto e){
		return new  ResponseEntity<StudentResponse>(employeeServices.getDataByResttemplate(e),HttpStatus.OK);
	}

	@GetMapping("/")
	ResponseEntity<String> getTestData(){
		
		return new ResponseEntity<String>(employeeServices.getTestData(),HttpStatus.OK);
	}
}
