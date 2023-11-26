package com.projet.subject;

import java.util.List;

import com.projet.chapter.Chapter;
import com.projet.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subject {
@Id
@GeneratedValue
private Integer id;

private String name;

@ManyToMany(mappedBy = "subjects")
private List<Student> students;

@OneToMany(mappedBy = "subject")
private List<Chapter> chapters;
}
