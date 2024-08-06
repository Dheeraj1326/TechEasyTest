package com.techEasyTest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techEasyTest.model.Student;
import com.techEasyTest.model.Subject;
import com.techEasyTest.service.serviceImpl.StudentServiceImpl;
import com.techEasyTest.service.serviceImpl.SubjectServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;
	@Autowired
	private SubjectServiceImpl subjectService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> studentList(){
		return ResponseEntity.ok().body(studentService.studentList());
	}
	
	@PostMapping("/add-student")
	public ResponseEntity<Object> addStudent(@RequestBody Map<String, Object> payload){
		
		 String name = (String) payload.get("name");
	     String address = (String) payload.get("address");
	     List<Integer> subjectIds = ((List<Integer>)payload.get("subject_ids"));
	     
		// Sending response if any error or success messages.
		Map<String, Object> response = new HashMap<>();
		
	    // validate payload 
	    if (name == null || name.trim().isEmpty()) {
	        response.put("error", "Name is required");
	        return ResponseEntity.badRequest().body(response);
	    }
	    if (address == null || address.trim().isEmpty()) {
	        response.put("error", "Address is required");
	        return ResponseEntity.badRequest().body(response);
	    }
	    
	    //  getting subject from subject_ids from payload.
	    Set<Subject> subjects = new HashSet<>();
        for (Integer subjectId : subjectIds) {
            Subject subject = subjectService.findById(subjectId);
            if (subject != null) {
                subjects.add(subject);
            }
        }
        ArrayList arrayList = new ArrayList(subjects);
	    
        // set student data 
	    Student student = new Student();
	    student.setName(name);
	    student.setAddress(address);
	    student.setSubjects(arrayList);
	   
	    Student savedStudent = studentService.saveStudent(student);
	    
	    if(savedStudent == null) {
	    	response.put("error", "Something Went Wrong...");
	        return ResponseEntity.badRequest().body(response);
	    }
	    
	    response.put("success", "Student created.");
	    response.put("student", savedStudent);
	   
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
