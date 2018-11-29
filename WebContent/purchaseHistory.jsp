<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/mimosa.css">
		<title>商品購入履歴</title>
    </head>
	<body>
		<s:include value="header.jsp"/>
		<div id="contents">
			<h1 class="title">商品購入履歴画面</h1>
			<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
				<div class="submit_btn_box">
					<s:form action="DeletePurchaseHistoryAction">
						<s:submit value="履歴の全消去" class="submit_kyoukyo" />
					</s:form>
				</div>
				<s:iterator value="#session.purchaseHistoryInfoDtoList">
					<div class=horizontal-list-table>
						<div class=horizontal-list-table-left>
  							<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="300px" height="300px" />
						</div>
						<div class=horizontal-list-table-right>
							<s:label value="商品名"/><s:property value="productName"/><br>
							<s:label value="ふりがな"/><s:property value="productNameKana"/><br>
							<s:label value="値段"/><s:property value="price"/>円<br>
							<s:label value="発売会社名"/><s:property value="releaseCompany"/><br>
							<s:label value="発売年月日"/><s:property value="releaseDate"/><br>
						</div>
					</div>
				</s:iterator>
			</s:if>
			<s:else>
				<div class="rireki">
					商品購入履歴情報はありません。
				</div>
			</s:else>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>