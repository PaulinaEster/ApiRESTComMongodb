package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort; 
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Student createStudent(Student student) {
		if(student.getDepartment() != null) {
			departmentRepository.save(student.getDepartment());
		}
		if(student.getSubjects() != null && student.getSubjects().size() > 0) {
			subjectRepository.saveAll(student.getSubjects());
		}
		return repository.save(student);
	}

	public Student getUserById(String id) { 
		return repository.findById(id).get();
	}

	public Student deleteById(String id) {
		Student obj = this.getUserById(id);
		if(obj != null) {
			repository.deleteById(id);
		}
		return obj;
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public Student updateById(Student student) {
		Student obj = this.getUserById(student.getId());
		if(obj != null) {
			return repository.save(student);
		}
		return obj;
	}

	public List<Student> getByName(String name) {
		return repository.findByName(name);
		// return repository.getByName(name);
	}

	public Student studentByNameAndMail(String name, String mail) {
		return  repository.findByNameAndEmail(name, mail);
	}

	public List<Student> studentByNameOrMail(String name, String mail) {
		return repository.findByNameOrEmail(name, mail);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return repository.findAll(pageable).getContent();
	}

	public List<Student> allWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name" );
		return repository.findAll(sort);
	}

	public List<Student> byDepartmenteName(String deptName) {
		return repository.findByDepartmentDepartmentName(deptName);
	}

	public List<Student> bySubjectName(String subName) {
		return repository.findBySubjectsSubjectName(subName);
	}
 
	public List<Student> emailLike(String email) {
		return repository.findByEmailIsLike(email);
	}

	public List<Student> nameStartWith(String name) {
		return repository.findByNameStartsWith(name);
	}
	
	public List<Student> findByDepartmentId(String depId){
		return repository.findByDepartmentId(depId);
	}
	
	

}
