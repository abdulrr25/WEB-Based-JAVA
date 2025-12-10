package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.beans.Student;
import com.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService sservice;
	
	@RequestMapping("/showStudent")
	public ModelAndView getAllStudents(HttpSession session) {
		MyUser user = (MyUser) session.getAttribute("user");
		
		if(user!=null && user.getRole().equals("user")) {
			List<Student> slist= sservice.getAllStudent(); 
			return new ModelAndView("showStudent","slist",slist);

		}
		else {
			 return new ModelAndView("loginpage","message","pls provide credentials");

		}
	}
	
	@PostMapping("addstudent")
	public String ShowProductForm(Model mymodel) {
		mymodel.addAttribute("p1",new Student());
		return "insertStudent";
	}
	@PostMapping("insertStudent")
	public ModelAndView insertStudent(@ModelAttribute Student s) {
		System.out.println(s);
		boolean status=sservice.addStudent(s);
		return new ModelAndView("redirect:/student/showStudent");
	}
	
	@GetMapping("editStudent/{sid}")
	public ModelAndView editStudent(@PathVariable("sid") int sid) {
		Student s=sservice.getById(sid);
		if(s!=null) {
			return new ModelAndView("editStudent","stud",s);
		}else {
			return new ModelAndView("redirect:/student/showStudent");
		}
		
	}
	
	@PostMapping("/updatestudent")
	public ModelAndView updateStudent(@ModelAttribute Student s) {
		System.out.println(s);
		boolean status=sservice.updateStudent(s);
		return new ModelAndView("redirect:/student/showStudent");
		
	}
	
	
	
	@GetMapping("deletestudent/{sid}")
	public ModelAndView deleteStudent(@PathVariable int sid) {
		boolean status=sservice.deleteById(sid);
		return new ModelAndView("redirect:/student/showStudent");		
	}
}
