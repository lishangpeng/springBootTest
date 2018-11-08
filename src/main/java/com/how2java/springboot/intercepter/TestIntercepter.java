package com.how2java.springboot.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//return false表示取消当前请求
		//在进入handler方法之前，可以用来做身份验证
		System.out.println("进行了预处理");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//在进入handler方法之后，return modelAndView之前
		//可以用来放入一些公共的视图所需要的数据
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//可以用来做统一的异常处理，在ssm中可以用handlerExceptionResolver
		//在springBoot中可以用@ExceptionHandler@ControllerAdvice代替
	}

}
