<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/login.css?after">
<!-- 폰트어썸 아이콘 -->
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
</head>
<body>
	
		<c:choose>
			<c:when test="${userInfo eq null}">
			<div id="loginBox2">
				<p>Log in</p>
				<form action="login" method="post">
					<div id="idBox2"><i class="fa-regular fa-user"></i><input type="text" name="id" placeholder="아이디"></div>
					<div id="pwBox2"><i class="fa-solid fa-unlock-keyhole"></i><input type="password" name="pwd" placeholder="비밀번호"></div>
					<input type="submit" value="로그인">
				</form>
				<a href="memberRegister">회원가입</a><a href="">아이디 찾기</a><a href="">비밀번호 찾기</a>
			</div>
			</c:when>
		</c:choose>
</body>
</html>