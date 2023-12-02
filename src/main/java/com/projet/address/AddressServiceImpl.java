package com.projet.address;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

private final AddressRepository addressRepository;
private final AddressMapper mapper;

	@Override
	public void save(AddressRequest a) {
		Address address = mapper.toAddress(a);
		this.addressRepository.save(address);

	}

	@Override
	public AddressResponse findById(Integer id) {
		
		return this.addressRepository.findById(id)
				.map(mapper::toAddressDto)
				.orElse(new AddressResponse());
	}

	@Override
	public List<AddressResponse> findAll() {
		return this.addressRepository.findAll()
				.stream()
				.map(mapper::toAddressDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Integer id) {
		this.addressRepository.deleteById(id);

	}

}
