package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDao {

	List<Student> getAllStudent();

	boolean addStudent(Student s);

	Student FindById(int sid);

	boolean DeleteStudent(int sid);

	boolean UpdateStudent(Student s);

}
