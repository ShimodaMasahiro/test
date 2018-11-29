package com.internousdev.mimosa.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.UserInfoDAO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String password;
	private Map<String,Object> session;

	public String execute(){

		String result=ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		UserInfoDAO userInfoDAO=new UserInfoDAO();
		int count=userInfoDAO.resetPassword
			(String.valueOf(session.get("resetPasswordLoginId")),String.valueOf(session.get("newPassword")));
		if(count>0){
			result=SUCCESS;
		}else{
			result=ERROR;
		}
		return result;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
