<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>ログイン画面</title>
	</head>
	<body>
		<s:include value="header.jsp"/>
		<div id="contents">
			<h1 class="title">ログイン画面</h1>
			<s:form id="form" action="LoginAction">
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.loginIdErrorMessageList"><s:property/><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordErrorMessageList"><s:property/><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.notExsistsErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.notExsistsErrorMessageList"><s:property/><br></s:iterator>
						</div>
					</div>
				</s:if>
				<div class="main-form">
					<br><s:label class="log_label" value="ログインID:"/><br>
					<s:if test="#session.savedLoginIdFlg == true">
						<td class="log_put" style="border-style: hidden"><s:textfield name="loginId" class="txt" placeholder="ログインID"
							value='%{session.savedLoginId}' autocomplete="off"/></td>
					</s:if>
					<s:elseif test="#session.savedLoginIdFlg == false"><s:textfield name="loginId" class="txt" placeholder="ログインID"
							value='%{session.savedLoginId}' autocomplete="off"/></s:elseif>
					<s:else>
						<td style="border-style: hidden"><s:textfield name="loginId" class="txt" placeholder="ログインID"/></td>
					</s:else><br>
					<s:label class="log_label_pass" value="パスワード:"/>
					<a class="reset" href="../mimosa/ResetPasswordAction.action" tabindex="-1">パスワード再設定</a><br>
						<td class="log_put" style="border-style: hidden"><s:password name="password" class="txt" placeholder="パスワード" autocomplete="new-password"/></td>
					<div class="box">
						<s:if test="#session.savedLoginIdFlg == true">
							<s:checkbox name="savedLoginIdFlg" checked="checked"/>
						</s:if>
						<s:else>
							<s:checkbox name="savedLoginIdFlg"/>
						</s:else>
						<s:label value="ログインID保存" class="checker"/><br>
					</div><br>
					<div class="submit_btn_box">
						<s:submit value="ログイン" class="submit_kanryou" onclick="goLoginAction()"/>
					</div><br>
				</div>
			</s:form>
			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:form action="CreateUserAction">
						<s:submit value="新規ユーザー登録" class="submit_kyoukyo"/>
					</s:form>
				</div>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>