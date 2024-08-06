package com.techEasyTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techEasyTest.model.Subject;
import com.techEasyTest.service.serviceImpl.SubjectServiceImpl;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
	@Autowired
	private SubjectServiceImpl subjectService;

	@GetMapping("/list")
	public ResponseEntity<List<Subject>> subjectList() {
		return ResponseEntity.ok().body(subjectService.SubjectList());
	}

	@PostMapping("/add-subject")
	public ResponseEntity<Object> addSubject(@RequestBody Subject subject) {
		String name = subject.getName();
		Map<String, Object> response = new HashMap<>();

		if (name == null || name.trim().isEmpty()) {
			response.put("error", "Subject Name is required");
			return ResponseEntity.badRequest().body(response);
		}
		
		Subject addSubject = subjectService.addSubject(subject);
		if(addSubject == null)
		{
			response.put("error", "Something went wrong...");
			return ResponseEntity.badRequest().body(response);
		}
		
		response.put("success", "Subject created.");
		response.put("Subject", addSubject);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
