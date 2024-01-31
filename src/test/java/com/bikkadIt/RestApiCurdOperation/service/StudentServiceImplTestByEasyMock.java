package com.bikkadIt.RestApiCurdOperation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveAction;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.repository.StudentRepository;

//@SpringBootTest
class StudentServiceImplTestByEasyMock {

	StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	
	@Test
	public void saveStudentTest() {

//Create proxy object for StudentRepository interface	
		StudentRepository daoProxy = EasyMock.createMock(StudentRepository.class);
//Set that proxy object to StudentRepository i.e. setStuRepository
		studentServiceImpl.setStuRepository(daoProxy);
		
//Create object for Entity class		
		Student st=new Student();
		st.setStuId(1);
		st.setStuName("jkdj");
		st.setStuEmail("abcd@gmail.com");
		st.setStuPass("mangal@123");
		st.setStuAddr("Pune");
		System.out.println(st);
		
//This (expect and andReturn) is taken because of EasyMock			
		EasyMock.expect(daoProxy.save(st)).andReturn(st);

//Switch that StuRepository original object to proxy object inside ServiceImpl class
		EasyMock.replay(daoProxy);
		
//Call studentServiceImpl class method
		boolean actualResult = studentServiceImpl.saveStudent(st);
					
//assertTrue(actualResult);
		boolean expectedR=true;	
		
//Compare expected result with actual result		
		assertEquals(expectedR,actualResult);
		
	}
	
	
	@Test
	public void getStudentByIdTest() {
		
		//Create mock(alternative/proxy object) for dao layer
		StudentRepository daoProxy = EasyMock.createMock(StudentRepository.class);
		studentServiceImpl.setStuRepository(daoProxy);
		
		Student st=new Student();
		st.setStuId(1);
		st.setStuName("Mangal");
		st.setStuEmail("abcd@gmail.com");
		st.setStuPass("mangal@123");
		st.setStuAddr("Pune");
		
		Integer id=1;
		EasyMock.expect(daoProxy.findById(id)).andReturn(Optional.of(st));
		EasyMock.replay(daoProxy);
		Student stuById = studentServiceImpl.getStuById(id);
		
		assertEquals(st,stuById);
		
		}
	
	@Test
	public void getAllStudentTest() {
		
		//Create mock(alternative/proxy object) for dao layer
		StudentRepository daoProxy = EasyMock.createMock(StudentRepository.class);
		
		studentServiceImpl.setStuRepository(daoProxy);
		
		Student st=new Student();
		st.setStuId(1);
		st.setStuName("Mangal");
		st.setStuEmail("abcd@gmail.com");
		st.setStuPass("mangal@123");
		st.setStuAddr("Pune");
		
		Student st1=new Student();
		st1.setStuId(2);
		st1.setStuName("Mahi");
		st1.setStuEmail("xyz@gmail.com");
		st1.setStuPass("m@123");
		st1.setStuAddr("Beed");
		
		//We will create our own list
		List<Student> list=new ArrayList();
		list.add(st);
		list.add(st1);
		
		
		EasyMock.expect(daoProxy.findAll()).andReturn(list);
		EasyMock.replay(daoProxy);
		List<Student> stuList = studentServiceImpl.getAllStudent();
		int expectedResult1=2;
		assertEquals(expectedResult1,stuList.size());
		}
	
	@Test
	public void getStuById1Test() {
	
		
		StudentRepository createMock = EasyMock.createMock(StudentRepository.class);
		studentServiceImpl.setStuRepository(createMock);
		
		Student stu=new Student();
		stu.setStuId(6);
		stu.setStuName("Balaji");
		stu.setStuEmail("abc@gmain.com");
		stu.setStuPass("arf");
		stu.setStuAddr("ar");
		
		Student s=new Student();
		
		int id=6;
		EasyMock.expect(createMock.findById(id)).andReturn(Optional.of(s));
		EasyMock.replay(createMock);
		
		Student stuById1 = studentServiceImpl.getStuById1(6);
		System.out.println(stuById1);
				
		assertEquals(stu,stuById1);
		
		//assertEquals(expectedResult, actualResult);
			
	}
	
}
