package com.projet.address;

import org.springframework.stereotype.Service;

import com.projet.student.Student;

@Service
public class AddressMapper {
	public AddressResponse toAddressDto(Address address) {
		return AddressResponse.builder()
				.homeAddress(address.getHomeAddress())
				.build();
	}	
		
	public Address toAddress(AddressRequest addressRequest) {
		Address address = new Address();
		address.setId(addressRequest.getId());
		address.setHomeAddress(addressRequest.getHomeAddress());
		
		Student student = new Student();
		student.setId(addressRequest.getStudentId());
		address.setStudent(student);
		return address;
}
}