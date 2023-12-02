<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="include/header.jsp" %>
<%@ include file="include/sideMenu.jsp" %>
<%@ include file="include/login.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품</title>
<link rel="stylesheet" href="/resources/css/good.css?after">
</head>
<body>
	<c:choose>
		<c:when test="${userInfo ne null }">
			 <section>
				<div id="imgBox"><img src="/uploadImg/${bvo.imgUrl }" alt="상품사진1" /></div>
				<div id="textBox">
					<div id="userBox">
						<c:choose>
							<c:when test="${mvo.imgUrl eq null}">
								<img src="/resources/images/mypage.png" alt="유저프로필" />
							</c:when>
							<c:when test="${mvo.imgUrl ne null }">
								<img src="/uploadImg/${mvo.imgUrl }" alt="유저프로필" />
							</c:when>
						</c:choose>
						<p id="userName">${mvo.userNick }<br><span> ${bvo.regionName}</span></p>
						<form action="setChatRoom" method="post">
							<input type="hidden" name="sellerId" value="${mvo.userId}">
							<input type="hidden" name="buyerId" value="${userInfo.userId }">
							<input type="hidden" name="goodsId" value="${bvo.goodsId }">
							<input type="submit" value="메시지 보내기">
						</form>
					</div>
					<p id="text1">${bvo.title}</p>
					<p class="text2">${bvo.createdAt }</p>
					<p id="text3"><fmt:formatNumber value="${bvo.price}" pattern="#,###"/>원</p>
					<p id="content">${bvo.content}</p>
					<p class="text2" id="text4"><i class="fa-regular fa-heart"></i>${bvo.countWishList } ∙ <i class="fa-regular fa-comment"></i>${bvo.countChatRoom }</p>
				</div>
			</section>
		</c:when>
	</c:choose>
</body>
</html>