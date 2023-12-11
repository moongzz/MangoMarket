<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/findPage.css?after">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
<title>아이디 찾기</title>
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
		<h1 id="title">아이디 찾기</h1>
		<form action="findIdOK" method="post">
			<div id="phoneNumBox"><i class="fa-solid fa-phone"></i><input id="phoneNum" type="text" name="phone" placeholder="휴대전화번호" required></div>
			<input type="submit" value="아이디 찾기">
		</form>
		
		<c:choose>
			<c:when test="${findID eq null}">
			</c:when>
			<c:when test="${findID eq 'nothing' }">
				<h1 id="findID" class="find">해당하는 전화번호에는 가입되어 있지 않습니다.</h1>
				<a id="memberReqister" href="memberRegister">회원가입하러 가기</a>
			</c:when>
			<c:otherwise>
				<h1 id="findID" class="find">해당하는 아이디 : <span id="userId">${findID }</span></h1>
			</c:otherwise>
		</c:choose>
		
		<a id="findPWbtn" class="btn" href="findPassword">비밀번호 찾기</a>
	</section>
<script src="/resources/js/findID.js"></script>
</body>
</html>