<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, minimum-scale=1.0">
		<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
		<title>ヘッダー</title>
		<script>
			function goLoginAction() {
				document.getElementById("form").action="GoLoginAction";
			}
			function goMyPageAction() {
				document.getElementById("form").action="MyPageAction";
			}
			function goCartAction() {
				document.getElementById("form").action="CartAction";
			}
			function goProductListAction() {
				document.getElementById("categoryId").value=1;
				document.getElementById("form").action="ProductListAction";
			}
			function goLogoutAction() {
				document.getElementById("form").action="LogoutAction";
			}
			function goSearchItemAction() {
				document.getElementById("form-search").action="SearchItemAction";
			}
		</script>
	</head>
	<body>
        <header>
			<div id="header">
                <div class="header-top">
                    <div class="header-title">
                        <h1><a href="HomeAction" style="color: white;  text-decoration: none;" tabindex="-1">Mimosa</a></h1>
                    </div>
                    <div class="header-menu">
                        <s:form id="form">
	                        <ul>
	                            <li><s:submit value="カート" class="button" onclick="goCartAction();" tabindex="-1"/></li>
	                            <li><s:submit value="商品一覧" class="button" onclick="goProductListAction();" tabindex="-1"/></li>
		                            <s:if test="#session.logined==1">
					            <li><s:submit value="マイページ" class="button" onclick="goMyPageAction();" tabindex="-1"/></li>
									</s:if>
		                            <s:if test="#session.logined==1">
								<li><s:submit value="ログアウト" class="button" onclick="goLogoutAction();" tabindex="-1"/></li>
									</s:if>
									<s:else>
					        	<li><s:submit value="ログイン" class="button" onclick="goLoginAction();" tabindex="-1"/></li>
									</s:else>
	                        </ul>
                        </s:form>
                    </div>
                </div>
				<div class="header-bottom">
                    <s:form id="form-search" name="form">
	                   	<ul>
					        <s:if test='#session.containsKey("mCategoryDtoList")'>
					       	<li><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="category" id="categoryId"/></li>
					        </s:if>
					        <li class="keywords"><s:textfield name="keywords" class="key-text" placeholder="検索ワード" /></li>
	                        <li><button type="submit" class="search_btn" onclick="goSearchItemAction();" ><i class="fa fa-search"></i></button></li>
						</ul>
                    </s:form>
                </div>
            </div>
        </header>
	</body>
</html>