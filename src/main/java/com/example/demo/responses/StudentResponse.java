package com.example.demo.responses;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.demo.dtos.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	private StudentDto dto;
	private List<StudentDto> dtos;
	private HttpStatus status;
	private String message;
	private boolean error;
}
