package com.how2java.springboot.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.how2java.springboot.pojo.Test;

@Aspect
@Component
public class LogAspect {
	
	private static final Logger logger = LogManager.getLogger("用户操作日志");
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controller() {
		
	}
	
	@Before("controller()")
	public void log(JoinPoint joinPoint) {
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Test user = (Test) request.getSession().getAttribute("test");
		String userId = null;
		if (user!=null) {
			userId = user.getName();
		}
		
		Object[] args = joinPoint.getArgs();
		//注意不能直接放进去因为会变成一个字符串
		if (args!=null&&args.length>0) {
			for(int i=0;i<args.length;i++) {
				if (args[i] instanceof HttpServletRequest) {
					args[i] = "request对象";
				}else if (args[i] instanceof HttpServletResponse) {
					args[i] = "response对象";
				}else if (args[i] instanceof MultipartFile) {
					args[i] = "MultipartFile对象";
				}else if (args[i] instanceof BindingResult) {
					args[i] = "BindingResult对象";
				}
			}
		}
		
		//需要变成json agrs
		logger.info("用户id:{},方法签名:{},方法参数列表:{}",userId,joinPoint.getSignature());
	}
}
