<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>決済確認画面</title>
	</head>
	<body>
		<s:include value="header.jsp"/>
		<div id="contents">
			<h1 class="title">決済確認画面</h1>
			<s:if test="#session.destinationInfoDtoList.size() > 0">
				<div class="info">
					送り先情報を選択してください
				</div>
				<s:form id="form" action="SettlementCompleteAction">
					<s:iterator value="#session.destinationInfoDtoList" status="st">
						<div class="address">
							<div class="address-select">
								<s:if test="#st.index == 0">
									<input type="radio" name="id" checked="checked" value="<s:property value='id'/>"/>お届け先情報
								</s:if>
								<s:else>
									<input type="radio" name="id" value="<s:property value='id'/>"/>お届け先情報
								</s:else>
							</div>
							<table>
								<tr>
									<th><s:label value="名前"/></th>
									<td><s:property value="familyName"/><span> </span><s:property value="firstName"/></td>
								</tr>
								<tr>
									<th><s:label value="ふりがな"/></th>
									<td><s:property value="familyNameKana"/><span> </span><s:property value="firstNameKana"/></td>
								</tr>
								<tr>
									<th><s:label value="住所"/></th>
									<td><s:property value="userAddress"/></td>
								</tr>
								<tr>
									<th><s:label value="電話番号"/></th>
									<td><s:property value="telNumber"/></td>
								</tr>
								<tr>
									<th><s:label value="メールアドレス"/></th>
									<td><s:property value="email"/></td>
								</tr>
							</table>
						</div>
					</s:iterator>
					<div class="submit_btn_box">
						<div id=".contents-btn-set">
							<s:submit value="決済" class="submit_kanryou"/><br>
						</div>
					</div><br>
				</s:form>
			</s:if>
			<s:else>
				宛先情報はありません
			</s:else>
			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:form action="CreateDestinationAction">
						<s:form action="CreateDestinationAction.java">
							<s:submit value="新規登録" class="submit_kyoukyo"/>
						</s:form>
					</s:form>
				</div>
			</div><br>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>