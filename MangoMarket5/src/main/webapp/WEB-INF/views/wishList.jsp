<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>위시리스트</title>
<link rel="stylesheet" href="/resources/css/sellHistory.css?after">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
	<header>
		<p onclick="document.location.href='home'">
			<span class="header_Text1">MANGO</span>
			<span class="header_Text2">market</span>
			<span><img src="/resources/images/망고.png"></span>
		</p>
	</header>
	<section>
		<h1>WISHLIST</h1>
		<c:forEach var="dto" items="${list}">
			<div id="imgBox" onclick="document.location.href='showGood?goodsId=${dto.goodsId}'">
				<img src="/uploadImg/${dto.imgUrl }">
			</div>
			<div id="textBox">
				<p id="text1">${dto.title}</p>
				<p class="text2">${dto.createdAt }</p>
				<p class="text2" id="text4"><i class="fa-regular fa-heart"></i>${dto.countWishList} ∙ <i class="fa-regular fa-comment"></i> ${dto.countChatRoom}</p>
				<c:if test="${dto.status eq 'O' }">
					<c:set var="statusText" value="판매중"/>
				</c:if>
				<c:if test="${dto.status eq 'X' }">
					<c:set var="statusText" value="거래완료"/>
				</c:if>
				<div id="statusBox">${statusText }</div>
			</div>
		</c:forEach>
	</section>
</body>
</html>