package com.projet.subject;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

private final SubjectService service;
	
	
@PostMapping
public ResponseEntity<Void> save (@RequestBody @Valid SubjectRequest subject) {
	service.save(subject);
	return ResponseEntity
			.accepted()
			.build();
}
	
@GetMapping("/{subjectId}")
public ResponseEntity<SubjectResponse> findById(@PathVariable  Integer subjectId) {
return ResponseEntity.ok(service.findById(subjectId));
}	

@GetMapping
public ResponseEntity<List<SubjectResponse>> findAll(){
	return ResponseEntity.ok(service.findAll());
}

@PatchMapping("/{subjectId}/student/{studentId}")
public ResponseEntity<Void> assignSubjectToStudent(
		@PathVariable Integer subjectId,
		@PathVariable Integer studentId
		){

	service.assignSubjectToStudent(subjectId, studentId);
	return ResponseEntity
			.accepted()
			.build();
	
}
}
