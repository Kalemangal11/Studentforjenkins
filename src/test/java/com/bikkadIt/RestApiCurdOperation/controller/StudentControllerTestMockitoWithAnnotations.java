package com.bikkadIt.RestApiCurdOperation.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = {StudentControllerTestMockitoWithAnnotations.class})
	//This is for create container which contains all test cases
		//Annotation that can be specified on a test class that runs Spring Boot based tests
@ComponentScan(basePackages = "com.bikkadIt.RestApiCurdOperation")
	//This is for Scanning all the packages by using basePackage
@AutoConfigureMockMvc
	//This is for automatic configuration of MockMvc class or other mockito classes
		//Annotation that can be applied to a test class to enable and configureauto-configuration of MockMvc
@ContextConfiguration
	//This is for metadata(data about data) configuration
		//It defines class-level metadata that is used to determinehow to load and configure an ApplicationContext for integration tests. 

class StudentControllerTestMockitoWithAnnotations {

	@Mock
	private StudentServiceImpl si;
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	private StudentController sc;
	
	@BeforeEach
	public void setUp() {
		
	 mockMvc = MockMvcBuilders.standaloneSetup(sc).build();
		}
	
	@Test
	public void getAllStudentTest() throws Exception {
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
		
		mockMvc.perform(get("/getAllStudent"))
		.andExpectAll(status().isOk())
		.andDo(print());		
	}

//Not understood		
	@Test
	public void deleteStudentTest() throws Exception {
		Student stu=new Student();
		stu.setStuId(1);
		stu.setStuName("Mangal");
		stu.setStuEmail("abcd@gmail.com");
		stu.setStuPass("mangal@123");
		stu.setStuAddr("Pune");
		System.out.println(stu);
		
		Integer id=1;
		Mockito.when(si.getStuById(id)).thenReturn(stu);
		Mockito.when(si.deleteStudent(Mockito.any())).thenReturn(true);
		
//		mockMvc.perform(get("/deleteStudentByPathparam/{stuId}",id))
//		.andExpectAll(status().isFound())
//		.andDo(print());	
		
			}
	
//Not understood	
	@Test
	public void saveStudentTest() throws Exception {
		Student stu=new Student();
		stu.setStuId(1);
		stu.setStuName("Mangal");
		stu.setStuEmail("abcd@gmail.com");
		stu.setStuPass("mangal@123");
		stu.setStuAddr("Pune");
		System.out.println(stu);
		
		Mockito.when(si.saveStudent(Mockito.any())).thenReturn(true);
		
		//when(si.saveStudent(stu)).thenReturn(true);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String stuObject = objectMapper.writeValueAsString(stu);
//		
		mockMvc.perform(post("/saveStudent").content(stuObject)
				.contentType(MediaType.APPLICATION_JSON))//It will convert stuObject to json format
				.andExpect(status().isCreated())
				.andDo(print());
		
	System.out.println(stu);
	}
//getStudentById By Pathparam	
	@Test
	public void getStudentByIdByPathparamTest() throws Exception {
		Student stu=new Student();
		stu.setStuId(1);
		stu.setStuName("Mangal");
		stu.setStuEmail("abcd@gmail.com");
		stu.setStuPass("mangal@123");
		stu.setStuAddr("Pune");
		System.out.println(stu);
		
		Integer id=1;
		when(si.getStuById(id)).thenReturn(stu);
		
		mockMvc.perform(get("/getStudentByIdByPathparam/{stuId}",id))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath(".stuId").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath(".stuName").value("Mangal"))
				.andExpect(MockMvcResultMatchers.jsonPath(".stuEmail").value("abcd@gmail.com"))
				.andDo(print());
	}
	
	//getStudentById By Queryparam //Not understood
		@Test
		public void getStudentByIdByQueryparam() throws Exception {
			Student stu=new Student();
			stu.setStuId(1);
			stu.setStuName("Mangal");
			stu.setStuEmail("abcd@gmail.com");
			stu.setStuPass("mangal@123");
			stu.setStuAddr("Pune");
			System.out.println(stu);
			
			Integer id=1;
			when(si.getStuById(id)).thenReturn(stu);
			
			mockMvc.perform(get("/getStudentByIdByQueryParam")
			        .param("stuId","id"))
					.andExpect(status().isFound())
					.andExpect(MockMvcResultMatchers.jsonPath(".stuId").value(1))
					.andExpect(MockMvcResultMatchers.jsonPath(".stuName").value("Mangal"))
					.andExpect(MockMvcResultMatchers.jsonPath(".stuEmail").value("abcd@gmail.com"))
					.andDo(print());
		}
}
