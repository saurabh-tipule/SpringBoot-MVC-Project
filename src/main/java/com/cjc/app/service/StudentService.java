package com.cjc.app.service;

import java.util.List;

import com.cjc.app.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> getStudents();

	void deleteStudent(int rollno);
	
	Student getStudent(int rollno);

}
