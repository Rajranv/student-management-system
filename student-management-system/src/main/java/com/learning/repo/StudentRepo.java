package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Long>{

}
