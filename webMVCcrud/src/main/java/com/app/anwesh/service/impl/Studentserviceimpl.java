package com.app.anwesh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.anwesh.Entity.Student;
import com.app.anwesh.Repository.StudentRepository;
import com.app.anwesh.service.IStudentservice;

@Service
public class Studentserviceimpl implements IStudentservice {
	
	@Autowired
	private StudentRepository studentrepo;
	
	
	public Integer savestudent(Student s) {
		s=studentrepo.save(s);
		return s.getStdid();
	}

	public List<Student> getallstudent() {
		List<Student> list=studentrepo.findAll();
		return list;
	}

	public Student getstudent(Integer id) {
		Optional<Student> opt=studentrepo.findById(id);
		if(opt.isPresent())
		{
			Student s=opt.get();
			return s;
		}
		else
			return null;

		}
	public void deleteStudent(Integer id) {
		studentrepo.deleteById(id);
	}

	public void updateStudent(Student s) {
		studentrepo.save(s);

	}

}
