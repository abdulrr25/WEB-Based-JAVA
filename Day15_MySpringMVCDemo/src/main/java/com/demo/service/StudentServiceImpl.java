package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Student;
import com.demo.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao sdao;
	
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sdao.getAllStudent();
	}

	@Override
	public boolean addStudent(Student s) {
		// TODO Auto-generated method stub
		return sdao.addStudent(s);
	}

	@Override
	public Student getById(int sid) {
		// TODO Auto-generated method stub
		return sdao.FindById(sid);
	}

	@Override
	public boolean deleteById(int sid) {
		// TODO Auto-generated method stub
		return sdao.DeleteStudent(sid);
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		return sdao.UpdateStudent(s);
	}

}
