<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/findPage.css?after">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<title>비밀번호 찾기</title>
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
		<h1 id="title">비밀번호 찾기</h1>
		<form action="findPWOK" method="post">
			<div><span class="material-symbols-outlined">person</span><input type="text" name="id" placeholder="아이디" required></div>
			<div><span class="material-symbols-outlined">mail</span><input type="email" name="email" placeholder="이메일" required></div>
			<input type="submit" value="비밀번호 찾기">
		</form>
		
		<c:choose>
			<c:when test="${findPW eq null}">
			</c:when>
			<c:when test="${findPW eq 'nothing' }">
				<h1 id="findPW" class="find">해당하는 아이디, 이메일은 가입되어 있지 않습니다.</h1>
				<a id="memberReqister" href="memberRegister">회원가입하러 가기</a>
			</c:when>
			<c:otherwise>
				<h1 id="findPW">비밀번호 재설정</h1>
				<form action="resetPW" method="post">
					<div><span class="material-symbols-outlined">lock</span><input type="password" name="pwd" placeholder="비밀번호" required></div>
					<div><span class="material-symbols-outlined">lock</span><input type="password" name="passwordChk" placeholder="비밀번호 확인" required></div>
					<input type="hidden" name="id" value="${findPW.id }">
					<input type="hidden" name="email" value="${findPW.email }">
					<input type="submit" value="완료">
				</form>
			</c:otherwise>
		</c:choose>
		<a id="findIDbtn" class="btn" href="findID">아이디 찾기</a>
	</section>
</body>
</html>