package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Integer eid;
	private String ename;
	private Integer esalary;
	private String address;
	private String department;
	private String email;
}
