<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
		<title>パスワード再設定</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div id="contents">
			<div id="repass-wrapper">
				<div id="repass-title">
					<i class="fas fa-unlock-alt"></i><h3  style="display:inline;">パスワード再設定</h3><i class="fas fa-unlock-alt"></i>
				</div>
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							 <s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordIncorrectErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.newPasswordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.reConfirmationPasswordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.reConfirmationPasswordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<s:if test="!#session.reConfirmationPasswordIncorrectErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.reConfirmationPasswordIncorrectErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
				</s:if>
				<div id="repass-form-wrapper">
					<s:form action="ResetPasswordConfirmAction">
						<table id="repass-form">
							<tr>
								<th scope="row"><label>ログインID</label></th>
								<td><s:textfield name="loginId" placeholder="ログインID" class="txt"/></td>
							</tr>
							<tr>
								<th scope="row"><label>現在のパスワード</label></th>
								<td><s:password name="password" placeholder="現在のパスワード" class="txt"/></td>
							</tr>
							<tr>
								<th scope="row"><label>新しいパスワード</label></th>
								<td><s:password name="newPassword" placeholder="新しいパスワード" class="txt"/></td>
							</tr>
							<tr>
								<th scope="row"><label>(再確認)</label></th>
								<td><s:password name="reConfirmationPassword" placeholder="(再確認)" class="txt"/></td>
							</tr>
						</table>
						<div id="resetbtn">
							<s:submit value="パスワードの再設定" class="submit_kanryou" />
						</div>
					</s:form>
				</div>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>