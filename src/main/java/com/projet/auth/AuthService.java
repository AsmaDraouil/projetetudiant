package com.projet.auth;

import org.springframework.stereotype.Service;

import com.projet.student.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
private final AuthMapper mapper;
private final StudentRepository studentRepository;
	
public void register(AuthRequest authRequest) {

	var student = mapper.toStudent(authRequest);
	studentRepository.save(student);
}



}
