package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_demo")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Integer eid;
	@Column(name = "e_name")
	private String ename;
	@Column(name = "e_salary")
	private Integer esalary;
	@Column(name = "e_address")
	private String address;
	@Column(name = "e_department")
	private String department;
	@Column(name = "e_email")
	private String email;
}
