package com.techEasyTest.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techEasyTest.model.Student;
import com.techEasyTest.repository.StudentRepository;
import com.techEasyTest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return studentRepo.findAll(Sort.by(Direction.ASC, "name"));
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

}
