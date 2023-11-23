<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>
<%@ include file="include/sideMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>홈페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/home.css" />">
<!-- 폰트어썸 아이콘 -->
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="section" id= "section1">
    	<div id="textBox">
			<p id="bigText">당신 근처의<br>망고마켓</p>
			<p id="smallText">중고 거래부터 동네 정보까지, 이웃과 함께해요.<br>가깝고 따뜻한 당신의 근처를 만들어요.</p>
    	</div>
		<img id="section1_1" src="/resources/images/section1_1.png">
		<img id="section1_2" src="/resources/images/section1_2.png">
    </div>
    <div class="section" id= "section2">
		<div id="textBox">
			<p id="bigText">우리 동네<br>중고 직거래 마켓</p>
			<p id="smallText">동네 주민들과 따뜻한 거래를 지금 경험해보세요.</p>
			<input type="button" value="인기매물 보기">
			<input type="button" value="믿을 수 있는 중고거래">
    	</div>
		<img src="/resources/images/section2_1.png">
    </div>
    <div class="section" id= "section3">
		<div id="textBox">
			<p id="bigText">이웃과 함께 하는<br>동네생활</p>
			<p id="smallText">우리 동네의 다양한 이야기를 이웃과 함께 나누어요.</p>
			<div>
				<div class="circle"><i class="fa-solid fa-person-circle-question"></i></div>
				<p><strong>우리동네질문</strong><br>궁금한 게 있을 땐 이웃에게 물어보세요.</p>
			</div>
			<div>
				<div class="circle"><i class="fa-solid fa-scroll"></i></div>
				<p><strong>동네분실센터</strong><br>무언가를 잃어버렸을 때, 함께 찾을 수 있어요.</p>
			</div>
			<div>
				<div class="circle"><i class="fa-solid fa-comments"></i></div>
				<p><strong>동네모임</strong><br>관심사가 비슷한 이웃과 온오프라인으로 만나요.</p>
			</div>
    	</div>
		<img src="/resources/images/section2.png">
    </div>
    <div class="footer">
        <div class="footerBox">
            <p><span style="font-weight: bold;">대표</span> 문고은｜<span style="font-weight: bold;">사업자번호</span> 123-45-67890
            </p>
            <p><span style="font-weight: bold;">직업정보제공사업 신고번호</span> 1234-가나다라-5678</p>
            <p><span style="font-weight: bold;">주소</span> 서울특별시 강남구 강남대로78길</p>
            <p><span style="font-weight: bold;">전화</span> 1544-1234｜<span style="font-weight: bold;">고객문의</span>
                abc@gmale.com</p>
            <p style="font-weight: bold;">제휴 문의 광고 문의 PR 문의 IR 문의</p>
        </div>
    </div>
    
    <script src="/resources/js/sideMenu.js"></script>
</body>
</html>