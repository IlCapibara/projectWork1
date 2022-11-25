package com.enway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enway.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
