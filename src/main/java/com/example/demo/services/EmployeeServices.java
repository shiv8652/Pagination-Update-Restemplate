package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.entities.Employee;
import com.example.demo.mappers.Employeemapper;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.responses.EmployeeResponse;
import com.example.demo.responses.StudentResponse;

@Configuration
@Service
public class EmployeeServices {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired(required = true)
	private Employeemapper employeeMapper;
	@Autowired(required = true)
	private RestTemplate restTemplate;
	@Value("${rest.template.api}")
	private String getDataUrl;
	

	public EmployeeResponse updateEmplopyee(EmployeeDto dto) {
		try {
			Optional<Employee> employeeDb = employeeRepository.findById(dto.getEid());
			if(employeeDb.isPresent()) {
			Employee emp = employeeMapper.mapEmployeeDtoToEmployee(dto);
				Employee employeeToBeUpdated = employeeDb.get();
				employeeToBeUpdated.setEname(emp.getEname());
				employeeToBeUpdated.setDepartment(emp.getDepartment());
				employeeToBeUpdated.setAddress(emp.getAddress());
				employeeToBeUpdated.setEsalary(emp.getEsalary());
				employeeToBeUpdated.setEmail(emp.getEmail());
				employeeRepository.save(employeeToBeUpdated);
				EmployeeDto  edto = employeeMapper.mapEmployeeToEmployeeDto(employeeToBeUpdated);
				return new EmployeeResponse(edto, null,null, HttpStatus.OK,"User UPDATED SUCCESSFULLY", false);
			}else {
				return new EmployeeResponse(null, null,null, HttpStatus.BAD_REQUEST,"User Id DOES NOT EXIST", false);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
     		return new  EmployeeResponse(null, null,null, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR", true);
	}

	public EmployeeResponse getAllByPagination(int page, int size) {
		try {
		Page<Employee> asdn = employeeRepository.getAllEmployeeByPagination(PageRequest.of(page, size)); 
		Page<EmployeeDto> pageEmpDto = employeeMapper.mapEmployeePageToEmployeeDtoPage(asdn);
		if(pageEmpDto.isEmpty()) {
			return new EmployeeResponse(null, null, null, HttpStatus.OK, "Data Is Empty", false);
		}else {
			return new EmployeeResponse(null,null , pageEmpDto, HttpStatus.OK, "Data found Successfully", false);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
     		return new  EmployeeResponse(null, null,null, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR", true);
	}

	public StudentResponse getDataByResttemplate(EmployeeDto e) {
try {
	final HttpEntity<EmployeeDto> dgpsApiRequestHttpEntity = new HttpEntity<>(e);
	final ResponseEntity<StudentDto> response = restTemplate.exchange(getDataUrl,
			HttpMethod.POST, dgpsApiRequestHttpEntity, StudentDto.class);
	StudentDto response1 = response.getBody();
	return new StudentResponse(response1, null, HttpStatus.OK, "Rest-Template Woked Properly", false);
} catch (Exception e2) {
	e2.printStackTrace();
	System.out.println(e2);
}
return new StudentResponse(null, null, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR", true);
	}
	


	public String getTestData() {
		String test = "I hope you have a great day today";
		return test;
	}

	
	
}
