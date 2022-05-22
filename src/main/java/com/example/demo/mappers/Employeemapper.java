package com.example.demo.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.Employee;

@Mapper(componentModel = "spring")
public interface Employeemapper {
	
	Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto);
	EmployeeDto mapEmployeeToEmployeeDto(Employee employee);
	List<EmployeeDto> mapEmployeeListToEmployeeDtoList(List<Employee> employees);
	default Page<EmployeeDto> mapEmployeePageToEmployeeDtoPage(Page<Employee> employees){
		return employees.map(this::mapEmployeeToEmployeeDto);
	};
	


}
