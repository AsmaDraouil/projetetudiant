package com.projet.subject;

import java.util.List;

public interface SubjectService {
	void save (SubjectRequest subject);
	SubjectRequest findById(Integer id);
	List<SubjectResponse> findAll();
	void deleteById(Integer id);
}
