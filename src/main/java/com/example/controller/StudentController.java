package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	
	@Autowired
	StudentService service;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/getByName/{name}")
	public List<Student> getByName(@PathVariable String name){
		return service.getByName(name);
	}
	
	@GetMapping("/studentByNameAndMail")
	public Student studentByNameAndMail(@RequestParam String name, @RequestParam String mail){
		return service.studentByNameAndMail(name, mail);
	}
	
	@GetMapping("/studentByNameOrMail")
	public List<Student> studentByNameOrMail(@RequestParam String name, @RequestParam String mail){
		return service.studentByNameOrMail(name, mail);
	}
	
	@GetMapping("/allWithPagination")
	public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
		return service.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/allWithSorting")
	public List<Student> allWithSorting(){
		return service.allWithSorting();
	}
	
	@GetMapping("/byDepartmenteName")
	public List<Student> byDepartmenteName(@RequestParam String deptName){
		return service.byDepartmenteName(deptName);
	}
	
	@GetMapping("/bySubjectName")
	public List<Student> bySubjectName(@RequestParam String subName){
		return service.bySubjectName(subName);
	}
	
	@GetMapping("/emailLike")
	public List<Student> emailLike(@RequestParam String email){
		return service.emailLike(email);
	}
	
	@GetMapping("/nameStartWith")
	public List<Student> nameStartWith(@RequestParam String name){
		return service.nameStartWith(name);
	}
	
	@PutMapping("/update")
	public Student updateById(@RequestBody Student student) {
		return service.updateById(student);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Student deleteById(@PathVariable String id) {
		return service.deleteById(id);
	}
	
}
