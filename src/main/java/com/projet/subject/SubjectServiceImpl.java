package com.projet.subject;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.student.Student;
import com.projet.student.StudentResponse;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	
private final SubjectRepository subjectRepository;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
