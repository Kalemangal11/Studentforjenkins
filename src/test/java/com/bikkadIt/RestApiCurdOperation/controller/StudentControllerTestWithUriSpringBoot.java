package com.bikkadIt.RestApiCurdOperation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.service.StudentServiceI;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
	//Annotation that can be used for a Spring MVC test that focuses only onSpring MVC components. 

class StudentControllerTestWithUriSpringBoot {

	@MockBean
		//Annotation that can be used to add mocks to a Spring ApplicationContext
	private StudentServiceI stuService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllStudentTest() throws Exception {
		
		List<Student> list=new ArrayList();
		
		when(stuService.getAllStudent()).thenReturn(list);
		
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/getAllStudent");
		
		ResultActions performed= mockMvc.perform(request);
		
		MvcResult body= performed.andReturn();
		
		int status= body.getResponse().getStatus();
		
		System.out.println(status);
		
		assertEquals(200, status);
		
	}

}
