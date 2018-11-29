package com.internousdev.mimosa.action;
import  java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class  ResetPasswordAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	public String execute(){

		String result = ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("passwordIncorrectErrorMessageList");
		session.remove("newPasswordErrorMessageList");
		session.remove("reConfirmationPasswordErrorMessageList");
		session.remove("newPasswordIncorrectErrorMessageList");

		result = SUCCESS;
		return result;
	}

	//1文字ほかを＊にする
	public String concealPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;
		StringBuilder stringBuilder = new StringBuilder("****************");
		String concealPassword = stringBuilder.replace(beginIndex,endIndex, password.substring(beginIndex,endIndex)).toString();
		return concealPassword;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
