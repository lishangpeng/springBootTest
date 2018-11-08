package com.how2java.springboot.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.how2java.springboot.intercepter.TestIntercepter;

@Configuration
public class TestConfigure extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new TestIntercepter()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
