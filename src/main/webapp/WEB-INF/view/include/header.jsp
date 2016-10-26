<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
	<head>
		<%@ include file="./common.jsp" %>
		<%@ include file="./meta.jsp" %>
		<meta charset="utf-8">
		<title>介護計画書作成支援システム - はやまる</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="copyright" content="Best Reha">
		<link rel="stylesheet" type="text/css" href="${ctxp}/css/base_style.css?${it.token}" />
		<!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<script src="${ctxp}/js/base/openclose.js?${it.token}"></script>
	</head>

<body id="top">
	<div id="container">
		<div id="headerArea">
			<header>
				<p id="sysname">
					<span class="subSysname">計画書作成支援システム<br /></span>
					<span class="mainSysname">は&nbsp;や&nbsp;ま&nbsp;る</span>
				</p>
				<div id="info">
					<p class="centerName">${it.loginInfo.centerName}</p>
					<p class="loginName">${it.loginInfo.name}&nbsp;様</p>
					<p class="logout"><a href="${ctxp}/page/logout">ログアウト</a></p>
				</div>
			</header>

			<!-- トップメニュー -->
			<c:if test="${it.loginInfo.adminFlag == 0}">
				<%@ include file="./menu.jsp" %>
			</c:if>
			<c:if test="${it.loginInfo.adminFlag != 0}">
				<%@ include file="./menu_adm.jsp" %>
			</c:if>
		</div>