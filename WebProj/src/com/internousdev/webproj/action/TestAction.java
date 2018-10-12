package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private String username;
	
	private String password;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String getuserName(){
		return username;
	}
	
	public void setuserName(String username){
		this.username=username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setpassword(String password){
		this.password=password;
	}
}
