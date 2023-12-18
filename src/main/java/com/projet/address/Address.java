package com.projet.address;

import com.projet.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
private String homeAddress;
	
@OneToOne
@JoinColumn(name = "stdId")
private Student student;
	
}
