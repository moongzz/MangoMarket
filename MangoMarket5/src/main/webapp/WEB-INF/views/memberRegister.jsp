<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>
<%@ include file="include/sideMenu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/memberRegister.css?after">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
	<section>
		<form name="member" method="post" action="memberRegisterOK" onsubmit="return validateForm()">
			<div id="idpwBox">
				<div><span class="material-symbols-outlined">person</span><input type="text" name="id" placeholder="아이디" required></div>
				<div><span class="material-symbols-outlined">lock</span><input type="password" name="pwd" placeholder="비밀번호" required></div>
				<div><span class="material-symbols-outlined">lock</span><input type="password" name="passwordChk" placeholder="비밀번호 확인" required></div>
			</div>
			
			<div id="phoneBox">
				<div><span class="material-symbols-outlined">mail</span><input type="email" name="email" placeholder="이메일" required></div>
				<div><span class="material-symbols-outlined">face</span><input type="text" name="userName" placeholder="이름" required></div>
				<div><span class="material-symbols-outlined">badge</span><input type="text" name="userNick" placeholder="닉네임" required></div>
				<div id="phoneBox2">
					<select name="mobilePhone1">
						<option value="KT">KT</option>
						<option value="LGU+">LGU+</option>
						<option value="SKT">SKT</option>
					</select>
					<input id="phoneNum" type="text" name="phone" placeholder="휴대전화번호" required>	<br>
				</div>
			</div>
			<input type="submit" value="회원가입"><input type="reset" value="초기화">
		</form>
	</section>
<script src="/resources/js/memberRegister.js"></script>
</body>
</html>