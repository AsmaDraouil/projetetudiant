package com.projet.student;

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
public class StudentRequest {
@NotNull
private Integer id;
@NotNull
private String firstname;
@NotNull
private String lastname;
@NotNull
private int age;
}
