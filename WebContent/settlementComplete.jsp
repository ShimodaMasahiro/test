<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
   		<link rel="stylesheet" href="./css/mimosa.css">
		<title>決済完了</title>
	</head>
	<body>
		<s:include value="header.jsp"/>
		<div id="contents">
			<div class="kamaboko">
				<h1 class="title">決済完了画面</h1>
				<p>決済が完了しました。</p>
				<p>ご注文ありがとうございました</p>
			</div>
		</div>
		<s:include value="footer.jsp"/>
	</body>
</html>