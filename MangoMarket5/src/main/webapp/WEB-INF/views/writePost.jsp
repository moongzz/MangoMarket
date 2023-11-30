<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>
<%@ include file="include/login.jsp" %>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 작성</title>
<link rel="stylesheet" href="/resources/css/writePost.css?after">
<!-- 폰트어썸 아이콘 -->
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
</head>
<body>
	<c:choose>
		<c:when test="${userInfo ne null }">
			<section>
			<form id="writePostFrom" method="post" action="writePostOK" enctype="multipart/form-data">
				<img class="image-box" src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg">
				<div class="wrapper">
					<label for="file" class="upload-btn">
						<input type="file" name="goodImg" id="imgFile" accept="image/*" value="" required>
					</label>
				</div>
				<div id="textBox">
					<input type="text" name="title" placeholder="글 제목" required/><br>
					<input type="text" id="price" name="price" placeholder="₩ 가격" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required/><input type="checkbox" id="free" name="free" value="O"/><label for="free">나눔<span><i class="fa-solid fa-check"></i></span></label>
					<textarea name="content" cols="60" rows="25" name="content" placeholder="올릴 게시글 내용을 작성해주세요. (판매 금지 물품은 게시가 제한될 수 있어요.)" required></textarea>
				</div>
				<input type="submit" value="완료"/>
				<div id="categoryBox">
					<p id="categoryText">카테고리</p>
					<input type="radio" id="1" name="category" value="1"/>
					<label for="1">디지털기기</label>
					<div id="categoryBox2">
						<input type="radio" id="1_1" name="category2" value="1"/>
						<label for="1_1">모바일</label>
						<input type="radio" id="1_2" name="category2" value="2"/>
						<label for="1_2">가전제품</label>
						<input type="radio" id="1_3" name="category2" value="3"/>
						<label for="1_3">오디오/영상/관련기기</label>
						<input type="radio" id="1_4" name="category2" value="4"/>
						<label for="1_4">PC/노트북</label>
						<input type="radio" id="1_5" name="category2" value="5"/>
						<label for="1_5">게임/타이틀</label>
						<input type="radio" id="1_6" name="category2" value="6"/>
						<label for="1_6">카메라/DSLR</label>
						<input type="radio" id="1_7" name="category2" value="7"/>
						<label for="1_7">PC부품/저장장치</label>
					</div>
					<input type="radio" id="2" name="category" value="2"/>
					<label for="2">가구/인테리어</label>
					<div id="categoryBox2">
						<input type="radio" id="2_1" name="category2" value="1"/>
						<label for="2_1">가구</label>
						<input type="radio" id="2_2" name="category2" value="2"/>
						<label for="2_2">침구</label>
						<input type="radio" id="2_3" name="category2" value="3"/>
						<label for="2_3">수공예/수선</label>
						<input type="radio" id="2_4" name="category2" value="4"/>
						<label for="2_4">셀프 인테리어 용품</label>
						<input type="radio" id="2_5" name="category2" value="5"/>
						<label for="2_5">인테리어 소품</label>
						<input type="radio" id="2_6" name="category2" value="6"/>
						<label for="2_6">꽃/원예</label>
						<input type="radio" id="2_7" name="category2" value="7"/>
						<label for="2_7">조명</label>
					</div>
					<input type="radio" id="3" name="category" value="3"/>
					<label for="3">유아동</label>
					<div id="categoryBox2">
						<input type="radio" id="3_1" name="category2" value="1"/>
						<label for="3_1">베이비의류(0-2세)</label>
						<input type="radio" id="3_2" name="category2" value="2"/>
						<label for="3_2">아동의류(3-6세)</label>
						<input type="radio" id="3_3" name="category2" value="3"/>
						<label for="3_3">주니어류(7세~)</label>
						<input type="radio" id="3_4" name="category2" value="4"/>
						<label for="3_4">이유용품/유아식기</label>
						<input type="radio" id="3_5" name="category2" value="5"/>
						<label for="3_5">교육/완구/인형</label>
						<input type="radio" id="3_6" name="category2" value="6"/>
						<label for="3_6">유아동용품</label>
						<input type="radio" id="3_7" name="category2" value="7"/>
						<label for="3_7">출산/임부용품</label>
					</div>
					<input type="radio" id="4" name="category" value="4"/>
					<label for="4">중고차</label>
					<div id="categoryBox2">
						<input type="radio" id="4_1" name="category2" value="1"/>
						<label for="4_1">경차</label>
						<input type="radio" id="4_2" name="category2" value="2"/>
						<label for="4_2">소형차</label>
						<input type="radio" id="4_3" name="category2" value="3"/>
						<label for="4_3">준중형</label>
						<input type="radio" id="4_4" name="category2" value="4"/>
						<label for="4_4">중형</label>
						<input type="radio" id="4_5" name="category2" value="5"/>
						<label for="4_5">대형</label>
						<input type="radio" id="4_6" name="category2" value="6"/>
						<label for="4_6">suv</label>
						<input type="radio" id="4_7" name="category2" value="7"/>
						<label for="4_7">트럭</label>
					</div>
					<input type="radio" id="5" name="category" value="5"/>
					<label for="5">도서/문구</label>
					<div id="categoryBox2">
						<input type="radio" id="5_1" name="category2" value="1"/>
						<label for="5_1">도서</label>
						<input type="radio" id="5_2" name="category2" value="2"/>
						<label for="5_2">문구</label>
					</div>
					<input type="radio" id="6" name="category" value="6"/>
					<label for="6">티켓/교환권</label>
					<div id="categoryBox2">
						<input type="radio" id="6_1" name="category2" value="1"/>
						<label for="6_1">기프티콘/쿠폰</label>
						<input type="radio" id="6_2" name="category2" value="2"/>
						<label for="6_2">상품권</label>
						<input type="radio" id="6_3" name="category2" value="3"/>
						<label for="6_3">티켓</label>
					</div>
					<input type="radio" id="7" name="category" value="7"/>
					<label for="7">반려동물용품</label>
					<div id="categoryBox2">
						<input type="radio" id="7_1" name="category2" value="1"/>
						<label for="7_1">강아지 용품</label>
						<input type="radio" id="7_2" name="category2" value="2"/>
						<label for="7_2">강아지 사료/간식</label>
						<input type="radio" id="7_3" name="category2" value="3"/>
						<label for="7_3">기타(강아지)</label>
						<input type="radio" id="7_4" name="category2" value="4"/>
						<label for="7_4">고양이 용품</label>
						<input type="radio" id="7_5" name="category2" value="5"/>
						<label for="7_5">고양이 사료/간식</label>
						<input type="radio" id="7_6" name="category2" value="6"/>
						<label for="7_6">기타(고양이)</label>
						<input type="radio" id="7_7" name="category2" value="7"/>
						<label for="7_7">기타(반려동물)</label>
					</div>
					<input type="radio" id="8" name="category" value="8"/>
					<label for="8">기타중고물품</label>
					<input type="radio" id="9" name="category" value="9"/>
					<label for="9">삽니다</label>
				</div>
				<div id="regionBox">
					<input type="text" id="sample4_postcode" placeholder="우편번호" name="regionId" readonly>
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br />
					<!-- <input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="regionName"><br /> -->
 					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="roadAddress"><br />
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="jibunAddress"><br />
					<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailAddress"><br />
					<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="extraAddress"><br/>
				</div>
				<input type="hidden" name="sellerId" value=${userInfo.userId }>
				<input type="hidden" name="userNick" value=${userInfo.userNick }>
			</form>
			</section>
		</c:when>
	</c:choose>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/resources/js/writePost.js"></script>
</body>
</html>