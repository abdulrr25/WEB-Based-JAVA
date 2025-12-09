package com.demo.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.beans.MyUser;
import com.demo.beans.Student;
import com.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService sservice;

    // Get all students
    @GetMapping("/showstudent")
    public ResponseEntity<List<Student>> getAllStudents(HttpSession session) {
        // MyUser user = (MyUser) session.getAttribute("user");
        // if(user!=null && user.getRole().equals("user")) {
        List<Student> slist = sservice.getAllStudent();
        return ResponseEntity.ok(slist);
        // } else {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        //                          .body(null);
        // }
    }

    // Add new student
    @PostMapping("/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody Student s) {
        boolean status = sservice.addStudent(s);
        if (status) {
            return ResponseEntity.ok("Student added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add student");
        }
    }

    // Get student by ID
    @GetMapping("/editStudent/{sid}")
    public ResponseEntity<Student> editStudent(@PathVariable("sid") int sid) {
        Student s = sservice.getById(sid);
        if (s != null) {
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update student
    @PutMapping("/updatestudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student s) {
        boolean status = sservice.updateStudent(s);
        if (status) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update student");
        }
    }

    // Delete student
    @DeleteMapping("/deletestudent/{sid}")
    public ResponseEntity<String> deleteStudent(@PathVariable int sid) {
        boolean status = sservice.deleteById(sid);
        if (status) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete student");
        }
    }
}
