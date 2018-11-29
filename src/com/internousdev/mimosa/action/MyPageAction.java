package com.internousdev.mimosa.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.UserInfoDAO;
import com.internousdev.mimosa.dto.UserInfoDTO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	public String execute(){

		String result=ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		UserInfoDAO userInfoDAO=new UserInfoDAO();
		UserInfoDTO userInfoDTO=new UserInfoDTO();
		userInfoDTO =userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));
		if(userInfoDTO!=null){
			session.put("familyName",userInfoDTO.getFamilyName());
			session.put("firstName",userInfoDTO.getFirstName());
			session.put("familyNameKana",userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana",userInfoDTO.getFirstNameKana());
			session.put("sex",userInfoDTO.getSex());
			session.put("email", userInfoDTO.getEmail());
			result=SUCCESS;
		}
		return result;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}