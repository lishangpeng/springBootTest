package com.how2java.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.springboot.pojo.Student;
import com.how2java.springboot.service.TestService;

@Controller
public class StudentController {

	@Autowired
	TestService testService;
	
	@RequestMapping("/allStudent")
	public ModelAndView findAll() {
		List<Student> studentList = testService.findAll();
		ModelAndView modelAndView = new ModelAndView("student");
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	} 
}
