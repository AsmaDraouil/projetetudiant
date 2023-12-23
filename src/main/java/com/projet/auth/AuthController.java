package com.projet.auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthService service;


@PostMapping
public ResponseEntity<Void> register (@RequestBody @Valid AuthRequest authRequest) {
service.register(authRequest);
return ResponseEntity.accepted().build();
}




	
	
}
