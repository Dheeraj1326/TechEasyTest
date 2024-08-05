package com.techEasyTest.service;

import java.util.List;

import com.techEasyTest.model.Student;

public interface StudentService {
	
	public List<Student> studentList();
	
	public Student saveStudent(Student student);
	
}
