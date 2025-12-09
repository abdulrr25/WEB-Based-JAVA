package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub

		List<Student> slist = jdbctemplate.query("select * from student_details", (rs, n) -> {
			Student s = new Student();
			s.setSid(rs.getInt(1));
			s.setSname(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setPercentage(rs.getDouble(4));
			s.setAddress(rs.getString(5));

			return s;
		});
		return slist;
	}

	@Override
	public boolean addStudent(Student s) {
		// TODO Auto-generated method stub
		int n = jdbctemplate.update("insert into student_details values(?,?,?,?,?)", new Object[] { s.getSid(),s.getSname(), s.getEmail(), s.getPercentage(),s.getAddress() });
		System.out.println("percentage = "+s.getPercentage());
		return n > 0;
	}

	@Override
	public Student FindById(int sid) {
	    try {
	        String sql = "select * from student_details where sid=?";
	        Student s = jdbctemplate.queryForObject(
	            sql, 
	            new Object[] { sid },
	            BeanPropertyRowMapper.newInstance(Student.class)
	        );
	        return s;
	    } catch (EmptyResultDataAccessException e) {
	        System.out.println("No student found: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public boolean DeleteStudent(int sid) {
	    // Ensure table name matches all other methods: student_details
	    int n = jdbctemplate.update("DELETE FROM student_details WHERE sid=?", new Object[] {sid});
	    return n > 0;
	}

	@Override
	public boolean UpdateStudent(Student s) {
	    String sql = "UPDATE student_details SET sname=?, email=?, percentage=?, address=? WHERE sid=?";
	    
	    int n = jdbctemplate.update(sql, new Object[] {
	        s.getSname(),
	        s.getEmail(),
	        s.getPercentage(),
	        s.getAddress(),
	        s.getSid() 
	    });
	    return n > 0;
	}
}
