package com.example.demo.responses;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.example.demo.dtos.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
private EmployeeDto dto;
private List<EmployeeDto> dtos;
private Page<EmployeeDto> page;
private HttpStatus status;
private String message;
private boolean error;

}
