package com.projet.subject;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.projet.exception.StudentAssignmentException;
import com.projet.student.Student;
import com.projet.student.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

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

@Test
public void should_assign_subject_to_student() {

    // GIVEN
    Integer subjectId = 1;
    Integer studentId = 2;

    Subject subject = new Subject();
    subject.setId(subjectId);
    subject.setStudents(new ArrayList<>());

    Student student = new Student();
    student.setId(studentId);
    student.setSubjects(new ArrayList<>());


    when(studentRepository.findById(studentId))
            .thenReturn(Optional.of(student));

    when(subjectRepository.findById(subjectId))
            .thenReturn(Optional.of(subject));
   
    subjectService.assignSubjectToStudent(subjectId, studentId);

  
    Assertions.assertTrue(student.getSubjects().contains(subject));
    Assertions.assertTrue(subject.getStudents().contains(student));

    verify(subjectRepository, times(1)).save(subject);
    verify(studentRepository, times(1)).save(student);
}

@Test
public void should_throw_EntityNotFoundException_if_student_not_found() {

    when(studentRepository.findById(Mockito.anyInt()))
            .thenThrow(new EntityNotFoundException("No student found with ID::"));

    var exp = Assertions.assertThrows(EntityNotFoundException.class, () -> subjectService.assignSubjectToStudent(1, 1));
    Assertions.assertTrue(exp.getMessage().startsWith("No student found with ID::"));
}

@Test
public void should_throw_StudentAssignmentException_when_student_is_assigned_to_3_subjects() {

    // GIVEN
    Integer subjectId = 1;
    Integer studentId = 2;

    Subject subject = new Subject();
    subject.setId(subjectId);
    subject.setStudents(new ArrayList<>());

    Student student = new Student();
    student.setId(studentId);

    List<Subject> subjects = new ArrayList<>();
    subjects.add(Subject.builder().id(10).build());
    subjects.add(Subject.builder().id(20).build());
    subjects.add(Subject.builder().id(30).build());

    student.setSubjects(subjects);

    when(studentRepository.findById(studentId))
            .thenReturn(Optional.of(student));

    // THEN
    var exp = Assertions.assertThrows(StudentAssignmentException.class, () -> subjectService.assignSubjectToStudent(subjectId, studentId));
    Assertions.assertEquals(exp.getMessage(), "Student cannot be assigned to more than 3 subjects");
}


@Test
void should_throw_StudentAssignmentException_when_student_is_already_assigned() {
	Integer subjectId = 1;
    Integer studentId = 2;
    
}

@Test
public void should_throw_EntityNotFoundException_if_subject_not_found() {

    when(subjectRepository.findById(Mockito.anyInt()))
            .thenThrow(new EntityNotFoundException("No subject found with ID::"));

    var exp = Assertions.assertThrows(EntityNotFoundException.class, () -> subjectService.assignSubjectToStudent(1, 1));
    Assertions.assertTrue(exp.getMessage().startsWith("No subject found with ID::"));
}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

