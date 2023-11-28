package com.bikkadIt.RestApiCurdOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadIt.RestApiCurdOperation.model.Student2;
@Repository
public interface Student2repo extends JpaRepository<Student2, Integer> {

}
