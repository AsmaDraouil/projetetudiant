package com.projet.subject;

import org.springframework.stereotype.Service;


@Service
public class SubjectMapper {
	public SubjectResponse toSubjectDto(Subject sub) {
		return SubjectResponse.builder()
				.name(sub.getName())
				.build();
	}	
		
	public Subject toSubject(SubjectRequest sub) {
		Subject subject = new Subject();
		subject.setId(sub.getId());
		subject.setName(sub.getName());	
		return subject;
	}
}
