package com.projet.subject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubjectMapperTest {

private final SubjectMapper mapper = new SubjectMapper();
@Test
public void should_successfully_transform_subject_request_to_Subject() {
    SubjectRequest request = new SubjectRequest();
    request.setId(null);
    request.setName("Math");
    
    Subject subject = mapper.toSubject(request);

    Assertions.assertNull(subject.getId());
    Assertions.assertEquals( "Math", subject.getName());
    Assertions.assertNull(subject.getStudents());
    Assertions.assertNull(subject.getChapters());
}

public void should_successfully_transform_null_subject_request_to_Subject() {
    Subject subject = mapper.toSubject(null);
    Assertions.assertNotNull(subject);
}
	
	
	
	
	
	
	
	
	
	
}
