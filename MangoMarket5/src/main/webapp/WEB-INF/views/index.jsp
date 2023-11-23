<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>망고마켓</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/index.css" />">
		<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/index.css?after"> --%>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link href="https://fonts.googleapis.com/css2?family=Bungee&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Coda&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Antonio:wght@100&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
	</head>
	<body>
		<input id="mangoToggle" class="hide" type="checkbox">
	    <button id="Gobtn" onclick="document.location.href='home'">거래하러 가기 →</button>
	    <section>
	        <label class="btn btn-open" for="mangoToggle" onclick="window.scrollTo(0,0);"></label>
	        <!-- 버튼 안 내용 -->
	        <div id="inside">
	            <label class="btn-close" for="mangoToggle">X</label>
	            <!-- 이용안내 타이틀 -->
	            <div id="titleBox">
	                <p id="title"><span>Mango Market</span></p>
	                <p>망고마켓 이용안내</p>
	            </div>
	            <!-- 이용안내 텍스트 -->
	            <div id="contentBox">
	                <p id="p1"><span>MANNER</span>
	                <p id="p2">
	                    <a class="highlight">기본적으로 지켜야 하는 매너에는 무엇이 있을까요? 기본 매너인 만큼 꼭 지켜 주실 거라고
	                        믿어요🙂</a><br>
	                    <span>• 서로 존중해요. 우리 <a class="highlight">존댓말</a>로 대화해요.<br></span>
	                    <span>• 모두의 시간은 소중합니다. <a class="highlight">시간 약속</a>을 꼭 지켜주세요.<br></span>
	                    <span>• 절대로 중간에 연락 끊기는 일이 없도록 해요. (<a class="highlight">잠수는 절대 안 돼요</a>!)<br></span>
	                    <span>• 따뜻한 <a class="highlight">감사 인사</a>로 마무리를 지어요.<br></span>
	                    <span>• 어떤 상황에서도 <a class="highlight">욕설, 비방, 명예훼손 등</a>의 언행은 지양해주세요.<br></span>
	                    <span>• <a class="highlight">늦은 시간</a> 채팅은 부담스러울 수 있어요. 특히 새벽 시간에는 채팅을 자제해주세요.<br></span>
	                    <span>• 택배 거래는 부득이한 경우에만 요청해주세요. 당근마켓에서는 <a class="highlight">직거래</a>를 권장하고 있어요.</span>
	                </p>
	                <!-- p3 -->
	                <p id="p3">
	                    <a class="highlight" style="font-size: 30px;">따뜻한 동네생활 커뮤니티를 만들기 위한 약속을 지켜주세요.</a><br>
	                    <span>• 항상 <a class="highlight">솔직</a>하게 대화해요.<br></span>
	                    <span>• 서로 <a class="highlight">배려</a>하며, 약속을 잘 지켜요.<br></span>
	                    <span>• 이웃들이 잘 이해할 수 있도록 자세하고 <a class="highlight">정확</a>한 정보를 제공해요.<br></span>
	                    <span>• 동네생활은 우리 동네 근처 이웃을 위한 공간이에요. <a class="highlight">동네생활</a>과 관련된 글을 작성해주세요.<br></span>
	                    <span>• 광고/홍보 등의 게시글은 <a class="highlight">광고</a>를 이용해주세요.<br></span>
	                    <span>• 중고거래는 <a class="highlight">중고거래 게시판</a>을 이용해주세요.<br></span>
	                    <span>• 친분을 과시하지 않기로 해요. 혹시라도 다른 이웃들이 <a class="highlight">소외</a>되지 않도록 도와주세요.<br></span>
	                    <span>• 남녀노소 다양한 이웃이 <a class="highlight">함께하는 공간</a>이에요. 누군가에게 불편할 수 있는 글들은 올리지 않기로 해요.</span>
	                </p>
	                <p id="p1"><span>PROMISE</span>
	                <!-- p4 -->
	                <p id="p4">
	                    <a class="highlight">우리 동네의 따뜻한 거래를 위해 다음과 같은 약속을 꼭 지켜주세요.</a><br>
	                    <span>• 거래 <a class="highlight">매너</a>를 잘 지켜주세요.<br></span>
	                    <span>• 거래 <a class="highlight">약속</a>은 꼭 지켜주세요.<br></span>
	                    <span>• 이왕이면 근처에서 <a class="highlight">직거래</a>를 해주세요.<br></span>
	                    <span>• 타지역 <a class="highlight">대리인증</a> 등 행위를 엄격히 금지하고 있어요.<br></span>
	                    <span>• <a class="highlight">판매 금지 물품</a>은 판매할 수 없어요.<br></span>
	                    <span>• 거래와 관련없는 내용으로 <a class="highlight">상대방이 원하지 않는 채팅</a>을 보내는 행위를 금지하고 있어요.<br></span>
	                    <span>• <a class="highlight">광고/홍보</a>는 망고마켓 광고주센터에 등록된 광고만 허용합니다.<br></span>
	                    <span>• <a class="highlight">전문판매업자</a>의 게시글은 제한하고 있어요.<br></span>
	                    <span>• <a class="highlight">최대 2개</a>의 지역에 게시글을 올리고 거래할 수 있어요.<br></span>
	                    <span>• <a class="highlight">중복 게시글</a>이나 <a class="highlight">도배성 게시글</a>을 제한하고 있어요.<br></span>
	                    <span>• <a class="highlight">카테고리</a>를 준수해주세요.<br></span>
	                    <span>• 거래 관련 문제가 생겼을 때는 <a class="highlight">중고거래 게시판 거래 및 환불 정책</a>을 따르고 있어요.<br></span>
	                    <span>• 거래분쟁이 생겼을 때 상대방의 닉네임을 공개하면서 <a class="highlight">명예를 훼손</a>하는 글을 올리면 안 돼요.</span>
	                </p>
	            </div>
	        </div>
	    </section>
	
	    <div id="TreeBody"><img id="Tree" src="/resources/images/나무3.png">
	        <div id="titleText">
	            <span id="text1">Whoever said that money <br> can't buy happiness,<br> simply didn't know <br> where to
	                go
	                <br> shopping <br></span>
	            <span id="text2">-Bo Derek-</span>
	        </div>
	
	        <!-- 망고들 -->
	        <div id="MangoBody">
	            <img id="mango1" src="/resources/images/망고.png">
	            <img id="mango" src="/resources/images/망고.png">
	            <img id="mango3" src="/resources/images/망고.png">
	            <img id="mango4" src="/resources/images/망고.png">
	            <img id="mango5" src="/resources/images/망고.png">
	            <img id="mango6" src="/resources/images/망고.png">
	        </div>
	    </div>
	    <!-- 슝 올라오는 글자 -->
	    <div id="codepen">
	        <span id="c1">M</span>
	        <span id="c2">A</span>
	        <span id="c3">N</span>
	        <span id="c4">G</span>
	        <span id="c5">O</span>
	        <span id="c6">market</span>
	        <span id="c7"><img src="/resources/images/망고.png"></span>
	        <div id="bg"></div>
	    </div>
	</body>
</html>