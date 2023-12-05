<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>채팅방</title>
<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/chatRoom.css?after">
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
		<h1>채팅방</h1>
	    <c:forEach var="chatRoom" items="${chatRoomList}">
			<div id="chatRoomBox" onclick="document.location.href='chat?buyerId=${chatRoom.buyerId}&sellerId=${chatRoom.sellerId }&goodsId=${chatRoom.goodsId }'">
				<div id="createdAtBox">${chatRoom.createdAt}</div>
				<div id="userNick">${userNickText}</div>
				<div id="titleBox">${chatRoom.title}</div>
				<c:if test="${userInfo.userNick eq chatRoom.buyerNick}">
					<c:set var="userNickText" value="${chatRoom.sellerNick}"/>
				</c:if>
				<c:if test="${userInfo.userNick eq chatRoom.sellerNick }">
					<c:set var="userNickText" value="${chatRoom.buyerNick}"/>
				</c:if>
				<div id="imgBox">
					<img src="/uploadImg/${chatRoom.imgUrl}" alt="상품사진1" />
				</div>
			</div>
	    </c:forEach>
	</section>	
</body>
</html>