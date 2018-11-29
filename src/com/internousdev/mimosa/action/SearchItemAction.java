package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.ProductInfoDAO;
import com.internousdev.mimosa.dto.ProductInfoDTO;
import com.internousdev.mimosa.util.CommonUtility;
import com.internousdev.mimosa.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;

	private Map<String,Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute(){

		session.remove("cartflag");
		List<ProductInfoDTO> productInfoDtoList= new ArrayList<ProductInfoDTO>();
		List<String> keywordsErrorMessageList = new ArrayList<String>();

		String result=ERROR;
		session.remove("productInfoDtoList");
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		session.remove("keywordsErrorMessageList");
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();

		InputChecker inputChecker=new InputChecker();
		if(StringUtils.isBlank(keywords)){
			keywords="";
		} else {
			keywords = keywords.replaceAll("　", " ");
		}

		if(!(keywords.equals(""))){
			keywordsErrorMessageList=inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, false, true, false);
			if(keywordsErrorMessageList.size()!=0){
				session.put("keywordsErrorMessageList", keywordsErrorMessageList);
				return SUCCESS;
			}

		}

		Iterator<String> errorListIterator = keywordsErrorMessageList.iterator();
		if(!(errorListIterator.hasNext())){
			keywordsErrorMessageList = null; //nullを入れることで表の外枠を消す
		}

		switch(categoryId){
			case "1":
				productInfoDtoList=productInfoDAO.getProductInfoListAll(keywords.split(" "));
				result=SUCCESS;
				break;
			default:
				productInfoDtoList=productInfoDAO.getProductInfoListByKeywords(keywords.split(" "), categoryId);
				result=SUCCESS;
				break;
		}

		Iterator<ProductInfoDTO> productInfoDtoListIterator = productInfoDtoList.iterator();
		if(!(productInfoDtoListIterator.hasNext())){
			productInfoDtoList=null;
		}else{
			session.put("productInfoDtoList", productInfoDtoList);
		}

		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
