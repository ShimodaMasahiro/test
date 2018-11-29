package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.DestinationInfoDAO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private List<String> sexList= new ArrayList<String>();
	private String sex;
	private String email;
	private String telNumber;
	private String userAddress;
	private Map<String,Object> session;

	public String execute(){

		String result=ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();//valueOf 引数をString型にする
		int count= destinationInfoDao.insert(String.valueOf(session.get("loginId")),familyName,firstName,familyNameKana,firstNameKana,email,telNumber,userAddress);
	    if(count>0){
	    	result = SUCCESS;
	    }
	    return result;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public List<String > getSexList(){
		return sexList;
	}

	public void setSexList(List<String> sexList){
		this.sexList=sexList;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getTelNumber(){
		return telNumber;
	}

	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public String getUserAddress(){
		return userAddress;
	}

	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}
}