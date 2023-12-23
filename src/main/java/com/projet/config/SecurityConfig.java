package com.projet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
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
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			if ("asma".equals(username)) {
				return User.withUsername("asma").password("1234").roles("USER").build();
			}
				
			throw new UsernameNotFoundException("user not found");
		}
	};
}
	


@Bean
public PasswordEncoder passwordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}


}
