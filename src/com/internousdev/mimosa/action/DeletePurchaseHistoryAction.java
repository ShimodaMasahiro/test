package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.PurchaseHistoryInfoDAO;
import com.internousdev.mimosa.dto.PurchaseHistoryInfoDTO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware{
	private String sex;
	private List<String>sexList=new ArrayList<String>();
	private static final String MALE="男性";
	private static final String FEMALE="女性";
	private String defaultSexValue=MALE;
	private Map<String,Object> session;
	public String execute(){

		String result=ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO=new PurchaseHistoryInfoDAO();
		int count=purchaseHistoryInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
		if(count>0){
			List<PurchaseHistoryInfoDTO>purchaseHistoryInfoDtoList=
			purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginId")));

			Iterator<PurchaseHistoryInfoDTO>iterator=purchaseHistoryInfoDtoList.iterator();
			if(!(iterator.hasNext())){
				purchaseHistoryInfoDtoList=null;
			}
			session.put("purchaseHistoryInfoDtoList",purchaseHistoryInfoDtoList);
			sexList.add(MALE);
			sexList.add(FEMALE);
			result=SUCCESS;
		}
		return result;
	}

	public List<String>getSexList(){
		return sexList;
	}

	public void setSexList(List<String>sexList){
		this.sexList=sexList;
	}

	public String getDefaultSexValue(){
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue){
		this.defaultSexValue=defaultSexValue;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}