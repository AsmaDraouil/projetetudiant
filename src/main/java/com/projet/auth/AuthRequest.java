package com.projet.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
@NotNull(message = "firstname must not be null")
private String firstname;
@NotNull(message = "lastname must not be null")
private String lastname;
@NotNull(message = "password must not be null")
@NotEmpty(message = "password must not be null")
private String password;
@NotNull(message = "email must not be null")
@NotEmpty(message = "email must not be null")
@Email(message = "email is not well formatter")
private String email;
}
