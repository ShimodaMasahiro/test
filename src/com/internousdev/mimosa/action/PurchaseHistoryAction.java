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

public class PurchaseHistoryAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	public String execute(){

		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDao=new PurchaseHistoryInfoDAO();
		List<PurchaseHistoryInfoDTO>purchaseHistoryInfoDtoList=new ArrayList<PurchaseHistoryInfoDTO>();
		purchaseHistoryInfoDtoList=purchaseHistoryInfoDao.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
		Iterator<PurchaseHistoryInfoDTO>iterator=purchaseHistoryInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			purchaseHistoryInfoDtoList=null;
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		return SUCCESS;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
