package com.learning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Student;
import com.learning.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student create(@RequestBody Student student) {
		return studentService.create(student);
	}

	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {
		return studentService.read(id);
	}

	@PutMapping("/{id}")
	public Student update(@PathVariable Long id, @RequestBody Student student) {
		return studentService.update(id, student);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		studentService.delete(id);
	}

}
