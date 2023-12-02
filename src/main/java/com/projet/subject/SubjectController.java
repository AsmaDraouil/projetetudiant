package com.projet.subject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("{/subjects}")
@RequiredArgsConstructor
public class SubjectController {

private final SubjectService service;
	
	
@PostMapping
public void save (@RequestBody SubjectRequest subject) {
	service.save(subject);
}
	
@GetMapping("/{subjectId}")
public SubjectResponse findById(@PathVariable  Integer subjectId) {
return service.findById(subjectId);
}	

@GetMapping
public List<SubjectResponse> findAll(){
	return service.findAll();
}



}
