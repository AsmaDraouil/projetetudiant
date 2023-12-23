package com.projet.auth;

import org.springframework.stereotype.Service;

import com.projet.student.Student;

@Service
public class AuthMapper {
	
public Student toStudent(AuthRequest s) {
	Student student = new Student();
	student.setFirstname(s.getFirstname());
	student.setLastname(s.getLastname());
	student.setFirstname(s.getPassword());
	student.setLastname(s.getEmail());
	return student;
}
	
	
}
