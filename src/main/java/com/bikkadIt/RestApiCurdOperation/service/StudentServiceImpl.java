package com.bikkadIt.RestApiCurdOperation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bikkadIt.RestApiCurdOperation.model.Student;
import com.bikkadIt.RestApiCurdOperation.model.Student2;
import com.bikkadIt.RestApiCurdOperation.repository.Student2repo;
import com.bikkadIt.RestApiCurdOperation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepository stuRepository;
	

	public void setStuRepository(StudentRepository stuRepository) {
		this.stuRepository = stuRepository;
	}

	@Autowired
	private Student2repo sturepo;

//Insert single record operation	
	@Override
	 @Transactional(rollbackOn = Exception.class)
	public boolean saveStudent(Student stu) {
		Student save = stuRepository.save(stu);

		if (save != null) {
			return true;
		} else {
			return false;
		}

//		System.out.println(10 / 0);
//		Student2 st = new Student2(2, "String stuName", "String stuAddr", "String stuEmail", "String stuPass");
//		Student2 st1 = sturepo.save(st);

//		if (save != null) {
//			return true;
//		} else {
//			return false;
//		}
	}

//Retrive data operation	
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = stuRepository.findAll();
		return list;
	}

//Update data operation
	@Override
	public boolean updateStudent(Student stu) {
		Student update = stuRepository.save(stu);
		if (update != null) {
			return true;
		} else {
			return false;
		}
	}

//Delete data operation	
	@Override
	public boolean deleteAllStudent() {
		List<Student> findAll = stuRepository.findAll();
		if (findAll.isEmpty()) {
			return false;
		} else {
			stuRepository.deleteAll();
			return true;
		}
	}

//Insert multiple records
	@Override
	public boolean saveAllStudent(List<Student> stu) {
		List<Student> saveAll = stuRepository.saveAll(stu);
		if (saveAll.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean updateAllStu(List<Student> stu) {
		List<Student> saveAll = stuRepository.saveAll(stu);
		if (saveAll != null) {
			return true;
		} else {
			return false;
		}
	}

//get single record by path parameter
	@Override
	public Student getStuById(int stuId) {
		Student student = stuRepository.findById(stuId).get();
		return student;
	}

//get single record by Query parameter
	@Override
	public Student getStuById1(int stuId) {
		Student findById = stuRepository.findById(stuId).get();
		return findById;
	}

//Delete single record by path parameter
	@Override
	public boolean deleteStudent(int stuId) {
		Student findById = stuRepository.findById(stuId).get();
		if (findById != null) {
			stuRepository.deleteById(stuId);
			return true;
		} else {
			return false;
		}
	}

//Delete single record by Query parameter
	@Override
	public boolean deleteStudent1(int stuId) {
		List<Student> findAll = stuRepository.findAll();
		if (findAll != null) {
			stuRepository.deleteById(stuId);
			return true;
		} else {
			return false;
		}
	}

}
