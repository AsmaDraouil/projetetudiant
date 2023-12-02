package com.projet.address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
	public AddressResponse toAddressDto(Address address) {
		return AddressResponse.builder()
				.homeAddress(address.getHomeAddress())
				.build();
	}	
		
	public Address toAddress(AddressRequest a) {
		Address address = new Address();
		address.setId(a.getId());
		address.setHomeAddress(a.getHomeAddress());
		return address;
}
}