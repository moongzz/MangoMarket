<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객센터</title>
<link rel="stylesheet" href="/resources/css/customerCenter.css?after">
<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
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
		<p id="text1">안녕하세요<br>무엇을 도와드릴까요? <img src="/resources/images/망고.png"></p>
		<div id="searchBox"><i class="fa-solid fa-magnifying-glass"></i><input type="text" placeholder="궁금한 것을 검색해보세요."></div>
		<p id="text2">카테고리에서 찾기</p>
		<div id="menuBox">
			<div id="customerMenu">계정/인증/로그인<span><i class="fa-solid fa-chevron-right"></i></span></div><div id="customerMenu">중고거래<span><i class="fa-solid fa-chevron-right"></i></span></div><br>
			<div id="customerMenu">상품판매<span><i class="fa-solid fa-chevron-right"></i></span></div><div id="customerMenu">광고<span><i class="fa-solid fa-chevron-right"></i></span></div><br>
			<div id="customerMenu">동네생활<span><i class="fa-solid fa-chevron-right"></i></span></div><div id="customerMenu">기타<span><i class="fa-solid fa-chevron-right"></i></span></div>
		</div>
		<p id="text2">도움이 필요하신가요?</p>
		<div id="inquirybtn">문의하기</div>
	</section>
	<footer>
		<p id="text3">이용약관</p>
		<p id="text3">개인정보처리방침</p>
		<p id="text3">회사정보</p>
		<p class="mangoText" id="text3">© 망고마켓</p>
	</footer>
</body>
</html>