package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.CartInfoDAO;
import com.internousdev.mimosa.dto.CartInfoDTO;
import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private String keywords;
	private Map<String, Object> session;

	public String execute(){

		session.remove("cartflag");
		String result = ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		String userId = null;
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		session.remove("checkListErrorMessageList");

		//loginId 又は tempUserId をuserIdに代入
		//HomeActionが行われているため、loginId,tempUserIdの必ずどちらかは存在する
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		} else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}

		//userIdを元にカートの情報を入手、カートの情報が取り出せなくなった時はnullを返す
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}

		session.put("cartInfoDtoList", cartInfoDtoList);

		//totalPriceを計算
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.gettotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;

		return result;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}