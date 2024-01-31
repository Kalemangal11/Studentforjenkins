package com.bikkadIt.RestApiCurdOperation.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.repository.StudentRepository;
@SpringBootTest(classes= {StudentServiceImplTestByMockito.class})//It will create one container
											//It will contains all test cases
class StudentServiceImplTestByMockito {

	@Mock //It will not create actual object
	private StudentRepository StudentRepo;
	
	@InjectMocks //It will initialize the StudentServiceI object
	private StudentServiceImpl studentServiceI;

	@Test
	public void getAllStudentTest() {
		
//Create object of Entity Class and set values
		Student stu=new Student();
		stu.setStuId(111);
		stu.setStuName("Mangal");
		stu.setStuEmail("abc@gmail.com");
		stu.setStuPass("123456");
		stu.setStuAddr("Pune");

//Create List		
		List<Student> list=new ArrayList();
//Add Entity class object
		list.add(stu);
		
		when(StudentRepo.findAll()).thenReturn(list);
		
		List<Student> allStudent = studentServiceI.getAllStudent();
		assertEquals(1, allStudent.size());
		}
	
	@Test
	public void getStuByIdTest() {
		Student stu=new Student();
		stu.setStuId(111);
		stu.setStuName("Mangal");
		stu.setStuEmail("abc@gmail.com");
		stu.setStuPass("123456");
		stu.setStuAddr("Pune");
		
		List<Student> list=new ArrayList();
		list.add(stu);
		
		Integer id=111;

//This (when and thenReturn) is taken because of Mockito		
		when(StudentRepo.findById(id)).thenReturn(Optional.of(stu));

//Call studentServiceImpl method
		Student student = studentServiceI.getStuById(id);
		Integer stuId = student.getStuId();
//Compare output		
		assertEquals(111, stuId);
	}
	
	@Test
	public void saveStudentTest() {
		Student stu=new Student();
		stu.setStuId(222);
		stu.setStuName("Mahi");
		stu.setStuEmail("abc@gmail.com");
		stu.setStuPass("123456");
		stu.setStuAddr("Pune");
		
		when(StudentRepo.save(stu)).thenReturn(stu);
		
		boolean actualResult = studentServiceI.saveStudent(stu);
		
		assertEquals(true, actualResult);
		}
	
	@Test
	public void updateStudentTest() {
		Student stu=new Student();
		stu.setStuId(222);
		stu.setStuName("Mahi");
		stu.setStuEmail("abc@gmail.com");
		stu.setStuPass("123456");
		stu.setStuAddr("Pune");
		System.out.println(stu);
		
		stu.setStuName("Mahadev");
		when(StudentRepo.save(stu)).thenReturn(stu);
		System.out.println(stu);
		
		Student save = StudentRepo.save(stu);
		//boolean actualResult = studentServiceI.updateStudent(stu);
		//assertEquals(true, actualResult);//If return type is something other than void
						//OR
		studentServiceI.updateStudent(stu);//save() call 2 times so we use times(2)
		verify(StudentRepo,times(2)).save(stu);//If return type is void(nothing)
		
		assertEquals(stu.getStuId(), save.getStuId());
		
		assertEquals("Pune", save.getStuAddr());
		}
}
