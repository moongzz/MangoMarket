<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="include/sideMenu.jsp" %>
<%@ include file="include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메시지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/chat.css?after">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
</head>
<body>
	<section>
		<div id="chatHeader">
			<i id="chatIcon" class="fa-regular fa-comments"></i>
		</div>
		<div id="goodBox">
			<div id="imgBox"><img alt="게시물 이미지" src="/uploadImg/${bvo.imgUrl }"></div>
			<p id="text1">${bvo.title}</p><br>
			<p id="text2"><fmt:formatNumber value="${bvo.price}" pattern="#,###"/>원</p>
			<c:choose>
				<c:when test="${bvo.sellerId eq userInfo.userId}">
					<c:choose>
						<c:when test="${bvo.status eq 'O'}">
							<form method="post" action="completeSale">
								<input type="hidden" name="buyerId" value="${crvo.buyerId }">
								<input type="hidden" name="goodsId" value="${bvo.goodsId }">
								<input type="hidden" name="thumbnailPicLink" value="${bvo.imgUrl }">
								
								<input id="sellBtn" type="submit" value="유저에게 판매하겠습니다.">
							</form>
						</c:when>
						<c:otherwise>
					    	<div id="sellBtn">판매가 완료된 게시글입니다.</div>
			    		</c:otherwise>
					</c:choose>
			    </c:when>
		    </c:choose>
		</div>
		<div id="showChatBox">
			<c:forEach var="vo" items="${chatList}">
				<c:choose>
					<c:when test="${vo.fromId eq userInfo.userId}">
				    	<div id="senderMessage"><p id="contentText">${vo.content}</p></div><br>
				    </c:when>
				    <c:otherwise>
				    	<p>${vo.toNick }</p>
				    	<div id="receiverMessage"><p id="contentText">${vo.content}</p><p id="createdAtText">${vo.createdAt }</p></div><br>
				    </c:otherwise>
			    </c:choose>
			</c:forEach>
		</div>
		<div id="chatBox">
			<form action="sendMessage" method="post" id="sendMessage">
				<div id="textBox">
					<input type="text" name="content" placeholder="메시지 보내기" required/>
					<input type="hidden" name="fromId" value="${userInfo.userId }">
					<input type="hidden" name="buyer" value="${crvo.buyerId}">
					<input type="hidden" name="seller" value="${crvo.sellerId}">
					<input type="hidden" name="goodsId" value="${bvo.goodsId}">
				</div>
				<button type="submit"><i class="fa-solid fa-paper-plane"></i></button>
			</form>
		</div>
	</section>
</body>
<script type="text/javascript">
	window.onload=function(){
		let mySpace = document.getElementById("showChatBox");
		mySpace.scrollTop = mySpace.scrollHeight;
	};

</script>
</html>