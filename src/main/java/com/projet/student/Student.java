package com.projet.student;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.projet.address.Address;
import com.projet.subject.Subject;
import com.projet.user.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("STUDENT")
public class Student extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int age;

	@OneToOne(mappedBy = "student")
	private Address address;

	@ManyToMany
	@JoinTable(name = "stdSub", joinColumns = @JoinColumn(name = "std_id"), inverseJoinColumns = @JoinColumn(name = "sub_id"))
	@JsonManagedReference
	private List<Subject> subjects;

}
