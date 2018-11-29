package com.internousdev.mimosa.dto;

import java.util.Date;

public class DestinationInfoDTO  {

	private int id;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;
	private Date regist_date;
	private Date update_date;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String famliyName){
		this.familyName=famliyName;
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

	public Date getRegist_date(){
		return regist_date;
	}

	public void setRegist_date(Date regist_date){
		this.regist_date=regist_date;
	}

	public Date getUpdate_date(){
		return update_date;
	}

	public void setUpdate_date(Date update_date){
		this.update_date=update_date;
	}
}