package com.restAPI.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.crudoperations.entity.Student;
import com.restAPI.crudoperations.repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class StudentController {
	//to get all the student details
	//localhost:8080/students
	@Autowired
	StudentRepository repo;
	@GetMapping ("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}
	
	//to get student based on id Or Roll No

	//localhost:8080/students/1

	@GetMapping ("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		return student;
	}
	
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		//TODO: process POST request
		
		repo.save(student);
	}
	
	@PutMapping("students/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		//TODO: process PUT request
		Student student=repo.findById(id).get();
		student.setName("sara");
		student.setPercentage(91);
		student.setBranch("IT");
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("students/delete/{id}")
	public Student RemoveStudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		repo.delete(student);
		return student;
	}

}
