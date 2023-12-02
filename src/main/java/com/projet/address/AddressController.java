package com.projet.address;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adresses")
public class AddressController {

private final AddressService service;

@PostMapping
public void save (@RequestBody AddressRequest address) {
	service.save(address);
}


@GetMapping("/{addressId}")
public AddressResponse findById(@PathVariable Integer addressId) {
return service.findById(addressId);
}	


@GetMapping
public List<AddressResponse> findAll(){
	return service.findAll();
}



}
