package com.projet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projet.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserRepository userRepository;
	
	
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	http.csrf(AbstractHttpConfigurer::disable)
	.authorizeHttpRequests(req ->

	req.requestMatchers("/auth/**")
	.permitAll()
	.anyRequest()
	.authenticated()
			)
	.httpBasic(Customizer.withDefaults());
	
	return http.build();
	
}
@Bean
public UserDetailsService userDetailsService() {
	return new UserDetailsService() {
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	return userRepository.findByEmail(email)
	.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
	}
	};
}
	


@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}



}
