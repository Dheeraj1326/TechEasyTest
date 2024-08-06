package com.techEasyTest.service;

import java.util.List;

import com.techEasyTest.model.Subject;

public interface SubjectService {
	
  public List<Subject> SubjectList();
  
  public Subject addSubject(Subject subject);
  
  public Subject findById(long id);
  
}
