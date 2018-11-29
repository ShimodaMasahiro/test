<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>パスワード再設定確認</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div id="contents">
			<h1 class="title">パスワード再設定確認画面</h1>
			<s:form action ="ResetPasswordCompleteAction">
				<div class="confirm_form">
					<table class="list-table">
						<tr>
							<th scope="row"><s:label value="ログインID"/></th>
							<td><s:property value="#session.resetPasswordLoginId"/></td>
						</tr>
						<tr>
							<th scope="row"><s:label value="新しいパスワード"/></th>
							<td><s:property value="#session.concealedPassword"/></td>
						</tr>
					</table><br>
					<div class="submit_btn_box">
						<div id=".contents-btn-set">
							<s:submit value="再設定" class="submit_kanryou "/>
						</div>
					</div>
				</div>
			</s:form>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>