package com.enway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enway.entity.Academy;

import com.enway.entity.Student;
import com.enway.repository.AcademyRepository;
import com.enway.repository.StudentRepository;

@Service
public class StudentAcademyServiceImpl implements StudentAcademyService {

	@Autowired
	private AcademyRepository academyRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String checkAddOrUpdateAcademy(Academy academy) {

		String page = null;
		Academy academyAddedOrUpdate = null;

		if (academy != null) {

			academyAddedOrUpdate = academyRepository.save(academy);

			if (academyAddedOrUpdate != null) {

				page = "academies";

			}

			else {
				page = "error";

			}

		}

		else {
			page = "error";

		}

		return page;
	}

	@Override
	public String checkAddOrUpdateStudent(Student student) {
		String page = null;
		Student studentAddedOrUpdate = null;

		if (student != null) {

			studentAddedOrUpdate = studentRepository.save(student);

			if (studentAddedOrUpdate != null) {

				page = "student";

			}

			else {
				page = "error";

			}

		}

		else {
			page = "error";

		}

		return page;

	}

	@Override
	public List<Academy> FindAllAcademies() {

		return academyRepository.findAll();

	}

	@Override
	public List<Student> FindAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public String checkRemoveAcademyAndStudents(String code) {
		String page = null;

		if (academyRepository.existsById(code)) {
			academyRepository.deleteById(code);

			if (!studentRepository.existsById(code)) {

				page = "academies";
			}

			else {
				page = "error";

			}

		}

		else {
			page = "error";
		}
		return page;

	}

	@Override
	public String checkRemoveStudent(String passportNumber) {
		String page = null;

		if (studentRepository.existsById(passportNumber)) {

			studentRepository.deleteById(passportNumber);

			if (!studentRepository.existsById(passportNumber)) {

				page = "students";
			}

			else {
				page = "error";

			}

		}

		else {
			page = "error";
		}
		return page;

	}

	@Override
	public Student findStudentById(String passportNumber) {

		return studentRepository.findById(passportNumber).get();

	}

	@Override
	public Academy findAcademyById(String code) {

		return academyRepository.findById(code).get();

	}

}
