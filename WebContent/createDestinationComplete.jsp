<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>宛先情報完了</title>
		<script type="text/javascript">
			window.onload = function(){
			setInterval('backSettlementConfirmAction(back)',3000);
			}

			function backSettlementConfirmAction(form){
			form.submit();
			}
		</script>
	</head>
	<body>
		<s:include value="header.jsp" />
		<div id="contents">
			<div class="kamaboko">
				<h1 class="title">宛先確認情報完了画面</h1>
					宛先情報の登録が完了しました
			</div>
				<s:form action="SettlementConfirmAction" name="back">
					<s:iterator value="#session.cartInfoDtoList">
						<s:hidden name="productName" value="%{productName}"/>
						<s:hidden name="productNameKana" value="%{productNameKana}"/>
						<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
						<s:hidden name="imageFileName" value="%{imageFileName}"/>
						<s:hidden name="price" value="%{price}"/>
						<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
						<s:hidden name="releaseDate" value="%{releaseDate}"/>
						<s:hidden name="productCount" value="%{productCount}"/>
						<s:hidden name="subtotal" value="%{subtotal}"/>
						<s:hidden name="productId" value="%{productId}"/>
					</s:iterator>
				</s:form>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>