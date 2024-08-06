package com.techEasyTest.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techEasyTest.model.Subject;
import com.techEasyTest.repository.SubjectRepository;
import com.techEasyTest.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Override
	public List<Subject> SubjectList() {
		// TODO Auto-generated method stub
		return subjectRepo.findAll();
	}

	@Override
	public Subject addSubject(Subject subject) {
		// TODO Auto-generated method stub
		subject.setCreated(new Date());
		subject.setModified(new Date());
		subject.setStatus(1);
		return subjectRepo.save(subject);
	}

	@Override
	public Subject findById(long id) {
		// TODO Auto-generated method stub
		return subjectRepo.findSubjectById(id);
	}

}
