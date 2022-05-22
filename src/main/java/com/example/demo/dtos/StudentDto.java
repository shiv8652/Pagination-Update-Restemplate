package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Integer sid;
	private String sname;
	private String address;
	private String course;
	private Integer phoneNumber;
}
