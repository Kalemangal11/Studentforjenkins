package com.bikkadIt.RestApiCurdOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIt.RestApiCurdOperation.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{


	
}