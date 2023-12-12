package com.projet.student;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

private final StudentService service;


@PostMapping
public ResponseEntity<Void> save (@RequestBody @Valid StudentRequest student) {
	service.save(student);
	return ResponseEntity
			.accepted()
			.build();
}


@GetMapping("/{student-id}")
public ResponseEntity<StudentResponse>  findById(@PathVariable ("student-id") Integer studentId) {
return ResponseEntity.ok(service.findById(studentId));
}	


@GetMapping
public ResponseEntity<List<StudentResponse>> findAll(){
	return ResponseEntity.ok(service.findAll());
}

	
	
}
