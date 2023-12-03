package com.projet.subject;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projet.student.StudentRepository;

public class SubjectServiceImplTest {

@Mock
private SubjectRepository subjectRepository;
@Mock
private StudentRepository studentRepository;
@Mock
private SubjectMapper mapper;
@InjectMocks
private SubjectServiceImpl subjectService;

@BeforeEach	
void setUp() {
MockitoAnnotations.openMocks(this);
}

@Test
public void should_save_subject_successfully() {
    SubjectRequest request = new SubjectRequest();
    request.setId(null);
    request.setName("Math");

    Subject subject = Subject.builder()
            .id(null)
            .name("Math")
            .build();
    when(mapper.toSubject(request)).thenReturn(subject);

    subjectService.save(request);

    verify(subjectRepository, times(1)).save(subject);
}



}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

