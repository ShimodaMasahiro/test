package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.dao.UserInfoDAO;
import com.internousdev.mimosa.util.CommonUtility;
import com.internousdev.mimosa.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String createUserLoginId;
	private String password;
	private String defaultSexValue;
	private List<String> sexList = new ArrayList<String>();
	private Map<String, Object> session;

	public String execute() {

		List<String> familyNameErrorMessageList = new ArrayList<String>();
		List<String> firstNameErrorMessageList = new ArrayList<String>();
		List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
		List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
		List<String> emailErrorMessageList = new ArrayList<String>();
		List<String> loginIdErrorMessageList = new ArrayList<String>();
		List<String> passwordErrorMessageList = new ArrayList<String>();
		List<String> isExsistsErrorMessageList = new ArrayList<String>();

		String result = ERROR;
		CommonUtility commonUtility = new CommonUtility();
		if(!commonUtility.checkSession(session)) {
			return "sessionTimeOut";
		}

		InputChecker inputChecker = new InputChecker();

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("sex", sex);
		session.put("email", email);
		session.put("createUserLoginId", createUserLoginId);

		defaultSexValue = sex;

		familyNameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false, false, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false, false, false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false, false, false, false);
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", createUserLoginId, 1, 8, true, false, false, true, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);


		// 既に存在するユーザであるかをチェックする
		UserInfoDAO userInfoDao = new UserInfoDAO();
		if(userInfoDao.isExistsUserInfoByLoginId(createUserLoginId)) {
			isExsistsErrorMessageList.add("既に使用されているユーザIDです。");
		}

		if(familyNameErrorMessageList.size()==0
		&& firstNameErrorMessageList.size()==0
		&& familyNameKanaErrorMessageList.size()==0
		&& firstNameKanaErrorMessageList.size()==0
		&& emailErrorMessageList.size()==0
		&& loginIdErrorMessageList.size()==0
		&& passwordErrorMessageList.size()==0
		&& isExsistsErrorMessageList.size()==0) {
			result = SUCCESS;
		}else {
			session.put("familyNameErrorMessageList", familyNameErrorMessageList);
			session.put("firstNameErrorMessageList", firstNameErrorMessageList);
			session.put("familyNameKanaErrorMessageList", familyNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("isExistsErrorMessageList", isExsistsErrorMessageList);
			result = ERROR;
		}
		return result;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateUserLoginId() {
		return createUserLoginId;
	}

	public void setCreateUserLoginId(String createUserLoginId) {
		this.createUserLoginId = createUserLoginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}