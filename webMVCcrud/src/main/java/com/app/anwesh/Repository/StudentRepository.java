package com.app.anwesh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.anwesh.Entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
