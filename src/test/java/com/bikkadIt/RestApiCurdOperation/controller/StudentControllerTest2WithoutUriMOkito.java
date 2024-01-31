package com.bikkadIt.RestApiCurdOperation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.service.StudentServiceImpl;

@SpringBootTest(classes= {StudentControllerTest2WithoutUriMOkito.class})
class StudentControllerTest2WithoutUriMOkito {

	@Mock
	private StudentServiceImpl si;
	
	@InjectMocks
	private StudentController sc;
	
	@Test
	public void getAllStudentTest() {
		
		Student stu=new Student();
		stu.setStuId(1);
		stu.setStuName("Mangal");
		stu.setStuEmail("abcd@gmail.com");
		stu.setStuPass("mangal@123");
		stu.setStuAddr("Pune");
		System.out.println(stu);
		
		Student stu1=new Student();
		stu1.setStuId(2);
		stu1.setStuName("Mahi");
		stu1.setStuEmail("abcd@gmail.com");
		stu1.setStuPass("mangal@123");
		stu1.setStuAddr("Pune");
		System.out.println(stu1);
		
		
		List<Student> list=new ArrayList();
		list.add(stu);
		list.add(stu1);
		
		when(si.getAllStudent()).thenReturn(list);
		
		ResponseEntity<List<Student>> allStudent = sc.getAllStudent();
		
		HttpStatus statusCode = allStudent.getStatusCode();
		
		int size = allStudent.getBody().size();	
		
		assertEquals(2, size);
		
		assertEquals(HttpStatus.OK, statusCode);
		//HttpStatus.--code this should be same which came return HttpStatus code from 
				//StudentController Class
		
		HttpStatus ok = HttpStatus.OK;
		System.out.println(ok);
	}
	
	@Test
	public void saveStudentTest(){
		Student stu1=new Student();
		stu1.setStuId(2);
		stu1.setStuName("Mahi");
		stu1.setStuEmail("abcd@gmail.com");
		stu1.setStuPass("mangal@123");
		stu1.setStuAddr("Pune");
		System.out.println(stu1);
		
		when(si.saveStudent(stu1)).thenReturn(true);
//We need same return inside thenReturn() which came return from saveStudent(stu1)
		//which is present in StudentServiceImpl Class
		
		ResponseEntity<String> saveStudent;
		try {
			saveStudent = sc.saveStudent(stu1);
			HttpStatus statusCode = saveStudent.getStatusCode();
			assertEquals(HttpStatus.CREATED, statusCode);
		} catch (UserPrincipalNotFoundException e) {
			assertThrows(UserPrincipalNotFoundException.class, ()->sc.saveStudent(null));
		}
//HttpStatus.CREATED this should be same which came return HttpStatus code from 
		//StudentController Class
		}
	 
	@Test
	public void getStudentByIdTest() {
				
		Student stu1=new Student();
		stu1.setStuId(2);
		stu1.setStuName("Mahi");
		stu1.setStuEmail("abcd@gmail.com");
		stu1.setStuPass("mangal@123");
		stu1.setStuAddr("Pune");
		System.out.println(stu1);
		
		Integer id=2;
		when(si.getStuById(id)).thenReturn(stu1);
		
		ResponseEntity<Student> gotStudentById = sc.getStudentById(id);
		HttpStatus statusCode = gotStudentById.getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		}
	
	
}