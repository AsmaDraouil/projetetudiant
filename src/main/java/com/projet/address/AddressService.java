package com.projet.address;

import java.util.List;

public interface AddressService {
	void save (AddressRequest a);
	AddressResponse findById(Integer id);
	List<AddressResponse> findAll();
	void deleteById(Integer id);
}
