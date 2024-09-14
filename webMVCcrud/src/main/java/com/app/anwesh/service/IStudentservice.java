package com.app.anwesh.service;

import java.util.List;

import com.app.anwesh.Entity.Student;

public interface IStudentservice {
	
	Integer savestudent(Student s);
	List<Student> getallstudent();
	Student getstudent(Integer id);
	void deleteStudent(Integer id);
	void updateStudent(Student s);
}
