package com.how2java.springboot.pojo;

import java.io.Serializable;

public class Test implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String phonenum;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
