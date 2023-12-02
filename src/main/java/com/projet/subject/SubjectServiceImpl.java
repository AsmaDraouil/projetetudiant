package com.projet.subject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
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
		return this.subjectRepository.findAll()
				.stream()
				.map(mapper::toSubjectDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Integer id) {
		this.subjectRepository.deleteById(id);
	}

}
