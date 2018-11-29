<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>宛先情報記入画面</title>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div id="contents">
			<h1 class="title">宛先情報入力画面</h1>
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
			<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
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


			<div class="main-form">
				<s:form action="CreateDestinationConfirmAction"><br>
					<br><label class ="userLog">姓<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="familyName" class="txt" placeholder="姓"/></td><br>
					<label class ="userLog">名<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="firstName" class="txt" placeholder="名"/></td><br>
					<label class ="userLog">姓ふりがな<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="familyNameKana" class="txt" placeholder="姓ふりがな"/></td><br>
					<label class ="userLog">名ふりがな<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="firstNameKana" class="txt" placeholder="名ふりがな"/></td><br>
					<label class ="userLog">性別<span class="hissu">必須</span></label><br>
						<div class=usersex>
							<td style="border-style: hidden"><s:radio name="sex" list="sexList" value="{defaultSexValue}"/></td><br>
						</div>
					<br><label class ="userLog">住所<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="userAddress" class="txt"  placeholder="住所"/></td><br>
					<label class ="userLog">電話番号<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="telNumber" class="txt" placeholder="電話番号"/></td><br>
					<label class ="userLog">メールアドレス<span class="hissu">必須</span></label><br>
						<td style="border-style: hidden"><s:textfield name="email" class="txt"  placeholder="メールアドレス"/></td>
					<div class="submit_bth_box"><br>
						<div id=".contents-bth-set">
							<s:submit value="宛先情報確認" class="submit_kyoukyo" />
						</div>
					</div><br>
				</s:form>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>