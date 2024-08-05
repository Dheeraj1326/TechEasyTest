package com.techEasyTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techEasyTest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
