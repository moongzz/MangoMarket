<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/myPage.css?after">
<!-- 폰트어썸 아이콘 -->
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
		<div id="userBox">
			<div id="userImgBox">
				<c:choose>
					<c:when test="${userInfo.imgUrl eq null}">
						<img id="userImg" src="/resources/images/mypage.png" alt="user" /><p id="nick">${userInfo.userNick }</p>
					</c:when>
					<c:when test="${userInfo.imgUrl ne null }">
						<img id="userImg" src="/uploadImg/${userInfo.imgUrl}" alt="user" /><p id="nick">${userInfo.userNick }</p>
					</c:when>
				</c:choose>
				<form id="uploadUserImg" method="post" action="uploadUserImg" enctype="multipart/form-data">
					<div class="wrapper">
						<label for="file" class="upload-btn">
							<input type="file" name="imgUrl" id="imgFile" accept="image/*" value="" required>
						</label>
					</div>
					<input type="hidden" name="userId" value="${userInfo.userId }"/>
					<input type="submit" value="프로필 사진 등록" />
				</form>
			</div>
			<div id="emailphone">
				<p>이메일 <br><span>${userInfo.email }</span></p>
				<p>휴대폰번호 <br><span>${userInfo.phone }</span></p>
			</div>
			<input id="modifyBtn" type="button" value="수정하기">
		</div>
		<ul>
			<li onclick="document.location.href='wishListShow.do?userId=${userInfo.userId }'"><i class="fa-regular fa-heart"></i> 관심목록</li>
			<li onclick="document.location.href='sellHistory.do?userId=${userInfo.userId }'"><i class="fa-solid fa-receipt"></i> 판매내역</li>
			<li onclick="document.location.href='buyHistory.do?userId=${userInfo.userId }'"><i class="fa-solid fa-bag-shopping"></i> 구매내역</li>
		</ul>
		<div id="modal" class="modal-overlay">
		    <div class="modal-window">
		        <div class="close-area">X</div>
			    <div id="positionBox" class="boxLine">
					<form action="userModify" method="post">
						<div id="phoneBox">
							<div><span class="material-symbols-outlined">mail</span><input type="email" name="email" placeholder="이메일" required></div>
							<div><span class="material-symbols-outlined">badge</span><input type="text" name="userNick" placeholder="닉네임" required></div>
							<select name="mobilePhone1">
								<option value="KT">KT</option>
								<option value="LGU+">LGU+</option>
								<option value="SKT">SKT</option>
							</select>
							<input id="phoneNum" type="text" name="phone" placeholder="휴대전화번호" required>
							<input type="hidden" name="userId" value="${userInfo.userId }"/>
						</div>
						<input type="submit" value="수정하기"><input type="reset" value="초기화">
					</form>
		    	</div>
		    </div>
		</div>
	</section>
	<script src="/resources/js/myPage.js"></script>
</body>
</html>