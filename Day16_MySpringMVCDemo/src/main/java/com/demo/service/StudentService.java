package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	List<Student> getAllStudent();

	boolean addStudent(Student s);

	Student getById(int sid);

	boolean deleteById(int sid);

	boolean updateStudent(Student s);

}
