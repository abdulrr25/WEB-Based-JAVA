package com.demo.Day17_SpringBootMVC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloWorld {
	@GetMapping("/hello")
	public ModelAndView sayhello() {
		String msg="Hello";
		return new ModelAndView("hello","message",msg);
		
	}

}
