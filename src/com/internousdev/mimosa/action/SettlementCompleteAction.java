package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.CartInfoDAO;
import com.internousdev.mimosa.dao.PurchaseHistoryInfoDAO;
import com.internousdev.mimosa.dto.CartInfoDTO;
import com.internousdev.mimosa.dto.PurchaseHistoryInfoDTO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private String id;
	private Map<String,Object>session;

	public String execute(){

		String result=ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		@SuppressWarnings("unchecked")
		ArrayList<PurchaseHistoryInfoDTO>purchaseHistoryInfoDtoList=(ArrayList<PurchaseHistoryInfoDTO>)session.get("purchaseHistoryInfoDtoList");
		for(int i=0;i<purchaseHistoryInfoDtoList.size();i++){
			purchaseHistoryInfoDtoList.get(i).setDestinationId(Integer.parseInt(id));
		}

		//購入履歴
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO=new PurchaseHistoryInfoDAO();
		int registCount=0;
		int deleteCount=0;
		for(int i=0; i<purchaseHistoryInfoDtoList.size();i++){
			registCount +=purchaseHistoryInfoDAO.regist(
				String.valueOf(session.get("loginId")),
				purchaseHistoryInfoDtoList.get(i).getProductId(),
				purchaseHistoryInfoDtoList.get(i).getProductCount(),
				purchaseHistoryInfoDtoList.get(i).getDestinationId(),
				purchaseHistoryInfoDtoList.get(i).getSubtotal()
			);
		}

		if(registCount>0){
			CartInfoDAO cartInfoDAO=new CartInfoDAO();
			deleteCount=cartInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
			if(deleteCount>0){
				List<CartInfoDTO>cartInfoDtoList=new ArrayList<CartInfoDTO>();
				cartInfoDtoList=cartInfoDAO.getCartInfoDtoList(String.valueOf(session.get("loginId")));
				Iterator<CartInfoDTO>iterator=cartInfoDtoList.iterator();
				if(!(iterator.hasNext())){
					cartInfoDtoList=null;
				}
				session.put("cartInfoDtoList",cartInfoDtoList);
				int totalPrice=Integer.parseInt(String.valueOf(cartInfoDAO.gettotalPrice(String.valueOf(session.get("loginId")))));
				session.put("totalPrice",totalPrice);
				result=SUCCESS;
			}
		}

		return result;
		}

		public String getId(){
			return id;
		}

		public void setId(String id){
			this.id=id;
		}

		public Map<String,Object>getSession(){
			return session;
		}

		public void setSession(Map<String,Object>session){
			this.session=session;
		}
	}
