<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>ユーザー情報入力</title>
	</head>
	<body>
		<s:include value="header.jsp"/>
		<div id="contents">
			<h1 class="title">ユーザー情報画面入力</h1>
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
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
			<s:if test="!#session.isExistsErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.isExistsErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<div class="main-form">
				<s:form action="CreateUserConfirmAction">
					<br><label class ="userLog">姓<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="familyName" value="%{#session.familyName}" class="txt" placeholder="姓" /></td><br>
					<label class ="userLog">名<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="firstName" value="%{#session.firstName}" class="txt" placeholder="名" /></td><br>
					<label class ="userLog">姓ふりがな<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" class="txt" placeholder="姓ふりがな" /></td><br>
					<label class ="userLog">名ふりがな<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" class="txt" placeholder="名ふりがな" /></td><br>
					<label class ="userLogsex">性別<span class="hissu">必須</span></label><br>
						<div class=usersex>
							<td style="border-style: hidden"><s:radio name="sex" list="%{#session.sexList}" value="{defaultSexValue}" label="性別"/></td><br>
						</div>
					<br><label class ="userLog">メールアドレス<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="email" value="%{#session.email}" class="txt" placeholder="メールアドレス" /></td><br>
					<label class ="userLog">ログインID<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="createUserLoginId" value="%{#session.createUserLoginId}" class="txt" placeholder="ログインID" /></td><br>
					<label class ="userLog">パスワード<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:password name="password" value="" class="txt" placeholder="パスワード" autocomplete="new-password"/></td><br><br>
					<div class="submit_btn_box">
						<div id=".contents-btn-set">
							<s:submit value="登録" class="submit_kanryou" />
						</div><br>
					</div>
				</s:form>
			</div>
		</div>
		<div id="footer">
			<s:include value="footer.jsp"/>
		</div>
	</body>
</html>
