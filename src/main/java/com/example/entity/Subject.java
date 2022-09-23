package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subject")
public class Subject {

	@Id
	private String id;
	
	@Field(name = "subject_name")
	private String subjectName;
	
	@Field(name = "marks_obteined")
	private int marksObtained;
	
}
