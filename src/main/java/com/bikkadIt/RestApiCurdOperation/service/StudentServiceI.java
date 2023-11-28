package com.bikkadIt.RestApiCurdOperation.service;

import java.util.List;
import java.util.Optional;

import com.bikkadIt.RestApiCurdOperation.model.Student;

public interface StudentServiceI {
	
	public boolean saveStudent(Student stu);
	
	public List<Student> getAllStudent();
	
	public boolean updateStudent(Student stu);
	
	public boolean deleteAllStudent();
	
	public boolean saveAllStudent(List<Student> stu);

	public boolean updateAllStu(List<Student> stu);
	
	public Student getStuById(int stuId);

	public Student getStuById1(int stuId);
	
	public boolean deleteStudent(int stuId);
	
	public boolean deleteStudent1(int stuId);
}

