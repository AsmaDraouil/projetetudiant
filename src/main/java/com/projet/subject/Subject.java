package com.projet.subject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projet.chapter.Chapter;
import com.projet.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String name;

@ManyToMany(mappedBy = "subjects")
@JsonBackReference
private List<Student> students;

@OneToMany(mappedBy = "subject")
private List<Chapter> chapters;
}
