package com.how2java.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.springboot.mapper.TestMapper;
import com.how2java.springboot.pojo.Student;

@Service
public class TestService {
	@Autowired
	TestMapper testMapper;
	
	@Transactional
	public List<Student>  findAll(){
		return testMapper.findAll();
	}
	
}
