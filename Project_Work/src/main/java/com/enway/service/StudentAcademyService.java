package com.enway.service;

import java.util.List;

import com.enway.entity.Academy;
import com.enway.entity.Student;

public interface StudentAcademyService {

	public String checkAddOrUpdateAcademy(Academy academy);

	public String checkAddOrUpdateStudent(Student student);

	public List<Academy> FindAllAcademies();

	public List<Student> FindAllStudents();

	public String checkRemoveAcademyAndStudents(String code);

	public String checkRemoveStudent(String passportNumber);

	public Student findStudentById(String passportNumber);

	public Academy findAcademyById(String code);

}
