package com.example.entity;
 
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

/* SE DER ALGO ERRADO FOI PQ VC NÃO CRIOU O CONSTRUTOR COM TODOS OS ARGUNENTOS E N COLOCOU O @PersistenceConstructor */

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class Student{ 

	@Id
	private String id;
	 
	private String name;
	
	@Field(name = "mail")
	private String email;
	
	@DBRef
	private Department department;
	
	@DBRef
	private List<Subject> subjects; 

	public Student(String id, Department department) {
		super();
		this.id = id;
		this.department = department;
	}
	
	@Transient
	private double percentage;
	
	public double getPercentage() {
		if(subjects != null && subjects.size() > 0) {
			int total = 0;
			for( Subject subject : subjects ) {
				total += subject.getMarksObtained();
			}
			return total/subjects.size();
		}
		return 0.00;
	}
	
}
