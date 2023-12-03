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
		if(sub==null)
			return Subject.builder().build();
		  return Subject.builder()
	                .id(sub.getId())
	                .name(sub.getName())
	                .build();
	}
}
