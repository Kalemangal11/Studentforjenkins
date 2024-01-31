package com.bikkadIt.RestApiCurdOperation.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.service.StudentServiceI;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceI stuService;

//Insert Operation	
	@PostMapping(value = "/saveStudent", consumes = "application/json")
	public ResponseEntity<String> saveStudent(@RequestBody Student stu) throws UserPrincipalNotFoundException {
		boolean saveStu = stuService.saveStudent(stu);
		if (saveStu) {
			return new ResponseEntity<String>("Student data saved successfully", HttpStatus.CREATED);
		} else {
			throw new UserPrincipalNotFoundException("User not found");
		}
	}

//Retrival Operation	
	@GetMapping(value = "/getAllStudent", produces = "application/json")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> findAllStudent = stuService.getAllStudent();
		return new ResponseEntity<List<Student>>(findAllStudent, HttpStatus.OK);
	}

//Update Operation
	@PutMapping(value = "/updateStudent", consumes = "application/json")
	public ResponseEntity<String> updateStudent(@RequestBody Student stu) {
		boolean updateStudent = stuService.updateStudent(stu);
		if (updateStudent) {
			return new ResponseEntity<String>("Data updated successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Data not updated successfully", HttpStatus.BAD_REQUEST);
		}
	}

//Delete record/data operation
	@DeleteMapping(value = "/deleteAllStudent", produces = "application/json")
	public ResponseEntity<String> deleteAllStudent() {
		boolean deleteAllStudent = stuService.deleteAllStudent();
		if (deleteAllStudent) {
			return new ResponseEntity<String>("All records deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Records not deleted", HttpStatus.BAD_REQUEST);
		}
	}

//Insert multiple records
	@PostMapping(value = "/saveAllStudent", consumes = "application/json")
	public ResponseEntity<String> saveAllStudent(@RequestBody List<Student> stu) {
		boolean saveAll = stuService.saveAllStudent(stu);
		if (saveAll) {
			return new ResponseEntity<String>("All records inserted successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("All records not inserted successfully", HttpStatus.CREATED);
		}
	}

//Update all data
	@PutMapping(value = "/updateAllStudent", consumes = "application/json")
	public ResponseEntity<String> updateAllStu(List<Student> stu) {
		boolean updateAllStu = stuService.updateAllStu(stu);
		if (updateAllStu) {
			return new ResponseEntity<String>("All Data updated successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Data not updated successfully", HttpStatus.BAD_REQUEST);
		}
	}

//get single record by path parameter
	@GetMapping(value = "/getStudentByIdByPathparam/{stuId}", produces = "application/json")
	public ResponseEntity<Student> getStudentById(@PathVariable int stuId) {
		Student findById = stuService.getStuById(stuId);
		return new ResponseEntity<Student>(findById, HttpStatus.OK);
	}

//get single record by Query parameter
	@GetMapping(path = "/getStudentByIdByQueryparam", produces = "application/json")
	public ResponseEntity<Student> getStudentById1(@RequestParam int stuId) {
		Student findById = stuService.getStuById1(stuId);
		return new ResponseEntity<Student>(findById, HttpStatus.OK);
	}

//Delete single record path parameter
	@DeleteMapping(value = "/deleteStudentByPathparam/{stuId}")
	public ResponseEntity<String> deleteStudent(@PathVariable int stuId) throws UserPrincipalNotFoundException {
		stuService.getStuById(stuId);
		boolean deleteStudent = stuService.deleteStudent(stuId);
		if (deleteStudent) {
			return new ResponseEntity<String>("Single data deleted", HttpStatus.OK);
		} else {
			throw new UserPrincipalNotFoundException("User not found");
		}
	}

//Delete single record by Query parameter
	@DeleteMapping(path = "/deleteStudentByQueryparam")
	public ResponseEntity<String> deleteStudent1(@RequestParam int stuId) {
		boolean findAll = stuService.deleteStudent1(stuId);
		if (findAll) {
			return new ResponseEntity<String>("Single data deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Single data not deleted yet", HttpStatus.BAD_REQUEST);
		}
	}

}
