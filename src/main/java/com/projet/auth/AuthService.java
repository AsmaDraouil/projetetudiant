package com.projet.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.student.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
private final AuthMapper mapper;

private final StudentRepository studentRepository;
private final PasswordEncoder passwordEncoder;

public void register(AuthRequest authRequest) {

	var student = mapper.toStudent(authRequest);
	var encryptedPassword = passwordEncoder.encode(student.getPassword());
	student.setPassword(encryptedPassword);
	studentRepository.save(student);
}



}
