package com.techEasyTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techEasyTest.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
