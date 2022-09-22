package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class Department {
	
	@Field(name = "department_name")
	private String departmentName;
	
	private String location;

}
