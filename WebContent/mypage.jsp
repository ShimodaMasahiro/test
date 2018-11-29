<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>マイページ</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div id="contents">
			<div id ="mypage-wrapper">
				<div id="mypage-title-box"><h1 id="mypage-title">会員登録情報</h1></div>
				<div id="mypage-table-wrapper">
					<s:form action="PurchaseHistoryAction">
						<table id="mypage-form">
							<tr>
								<th scope="row"><s:label value="姓"/></th>
								<td><s:property value="#session.familyName"/></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="名"/></th>
								<td><s:property value="#session.firstName"/></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="姓(ふりがな)"/></th>
								<td><s:property value="#session.familyNameKana"/></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="名(ふりがな)"/></th>
								<td><s:property value="#session.firstNameKana"/></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="性別"/></th>
								<td><s:if test="#session.sex==0">男性</s:if>
								<s:if test="#session.sex==1">女性</s:if></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="メールアドレス"/></th>
								<td><s:property value="#session.email"/></td>
							</tr>
						</table>
						<div class="mypage-btn">
							<s:submit value="購入履歴" class="submit_kyoukyo" />
						</div>
					</s:form>
				</div>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>