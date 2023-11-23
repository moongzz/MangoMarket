<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/resources/css/header.css?after">
<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>

<div class="header">
	<p onclick="document.location.href='home'">
		<span class="header_Text1">MANGO</span>
		<span class="header_Text2">market</span>
		<span><img src="/resources/images/망고.png"></span>
	</p>
	<form>
		<input id="searchBox" type="text" name="search" placeholder="물품이나 동네를 검색해보세요">
		<input id="searchbtn" type="submit" value="채팅하기">
	</form>
	<div id="userBox">
		<c:choose>
			<c:when test="${userInfo eq null}">
				<ul>
					<li id="loginBtn"><a>로그인/회원가입</a></li>
				</ul>
			</c:when>
			<c:when test="${userInfo ne null }">
				<li id="mypageBtn"><a href="myPage">${userInfo.userNick } 님 환영합니다!</a></li>
				<li id="logoutBtn"><a href="logout">로그아웃</a></li>
				<li id="chatRoom"><i class="fa-regular fa-envelope"></i> <a href="chatRoom?userId=${userInfo.userId }">채팅방</a></li>
			</c:when>
		</c:choose>
	</div>
	<div id="informationCenter" onclick="document.location.href='customerCenter'">고객센터</div>
	<div id="modal" class="modal-overlay">
	    <div class="modal-window">
	        <div class="close-area">X</div>
		    <div id="positionBox" class="boxLine">
				<form action="login" method="post">
					<div id="idBox"><i class="fa-regular fa-user"></i><input type="text" name="id" placeholder="아이디"></div>
					<div id="pwBox"><i class="fa-solid fa-unlock-keyhole"></i><input type="password" name="pwd" placeholder="비밀번호"></div>
					<input type="submit" value="로그인">
				</form>
				<a href="memberRegister.do">회원가입</a><a href="">아이디 찾기</a><a href="">비밀번호 찾기</a>		
	    	</div>
	    </div>
	</div>
</div>
<script src="/resources/js/header.js"></script>