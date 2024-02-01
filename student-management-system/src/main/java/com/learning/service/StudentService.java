package com.learning.service;

import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.entity.Student;
import com.learning.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	// Create
	public Student create(Student student) {

		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}

	// Read
	public Student read(Long id) {

		Optional<Student> optional = studentRepo.findById(id);
		boolean isDataPresent = optional.isPresent();
		if (isDataPresent) {
			Student savedStudent = optional.get();
			return savedStudent;
		}

		return null;
	}

	// Update
	public Student update(Long id, Student student) {
		Student savedStudent = read(id);
		if (Objects.nonNull(savedStudent)) {

			savedStudent.setStudentId(student.getStudentId());
			savedStudent.setName(student.getName());
			savedStudent.setAge(student.getAge());
			savedStudent.setPhoneNumber(student.getPhoneNumber());
			savedStudent.setCourse(student.getCourse());
			studentRepo.save(savedStudent);
			return savedStudent;
		}
		return null;

	}

	// delete
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}

}
