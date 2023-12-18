package com.projet.student;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projet.address.Address;
import com.projet.subject.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String firstname;
private String lastname;
private int age;

@OneToOne(mappedBy = "student")
private Address address;

@ManyToMany
@JoinTable(
		name = "stdSub",
		joinColumns = @JoinColumn(name = "std_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "sub_id", referencedColumnName = "id")
		)
@JsonManagedReference
private List<Subject> subjects;


}
