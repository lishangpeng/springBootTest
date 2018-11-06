package com.how2java.springboot.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.how2java.springboot.pojo.Test;
	
@RestController
public class TestController {
	
	@CrossOrigin
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public Test returnTest() {
		Test test = new Test();
		test.setEmail("123123@11.com");
		test.setName("lsp");
		test.setPhonenum("27384");
		return test;
	}
}
