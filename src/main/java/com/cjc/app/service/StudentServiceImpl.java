package com.cjc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.model.Student;
import com.cjc.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentrepository;

	@Override
	public void saveStudent(Student student) {
		System.out.println("In Service Layer :" + student);
		studentrepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentrepository.findAll();
	}

	@Override
	public void deleteStudent(int rollno) {
		studentrepository.deleteById(rollno);
	}

	@Override
	public Student getStudent(int rollno) {

		return studentrepository.findById(rollno).get();
	}
}
