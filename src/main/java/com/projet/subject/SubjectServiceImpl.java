package com.projet.subject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projet.exception.StudentAssignmentException;
import com.projet.student.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	
private final SubjectRepository subjectRepository;
private final StudentRepository studentRepository;
private final SubjectMapper mapper;

	@Override
	public void save(SubjectRequest subject) {
		Subject s = mapper.toSubject(subject);
		this.subjectRepository.save(s);

	}

	@Override
	public SubjectResponse findById(Integer id) {		
		return this.subjectRepository.findById(id)
				.map(mapper::toSubjectDto)
				.orElse(new SubjectResponse());
	}

	@Override
	public List<SubjectResponse> findAll() {
		return this.subjectRepository.findAll()
				.stream()
				.map(mapper::toSubjectDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Integer id) {
		this.subjectRepository.deleteById(id);
	}

	@Override
	public void assignSubjectToStudent(Integer subjectId, Integer studentId) {
		 var student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new EntityNotFoundException("No student found with ID:: " + studentId));

	        if (student.getSubjects().size() >= 3) {
	            throw new StudentAssignmentException("Student cannot be assigned to more than 3 subjects");
	        }

	        var alreadyAssigned = student.getSubjects()
	                .stream()
	                .map(Subject::getId)
	                .anyMatch(id -> Objects.equals(id, subjectId));
	        if (alreadyAssigned) {
	            throw new StudentAssignmentException("Student is already assigned to this subject");
	        }

	        var subject = subjectRepository.findById(subjectId)
	                .orElseThrow(() -> new EntityNotFoundException("no subject found with ID:: " + studentId));

	        student.getSubjects().add(subject);
	        subject.getStudents().add(student);

	        studentRepository.save(student);
	        subjectRepository.save(subject);
		
	}

}
