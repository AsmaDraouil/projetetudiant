package com.projet.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

private final StudentService service;

public StudentController (StudentService service) {
	this.service=service;
}

@PostMapping
public void save (@RequestBody StudentRequest student) {
	service.save(student);
}


@GetMapping("/{student-id}")
public StudentResponse findById(@PathVariable ("student-id") Integer studentId) {
return service.findById(studentId);
}	


@GetMapping
public List<StudentResponse> findAll(){
	return service.findAll();
}

	
	
}
