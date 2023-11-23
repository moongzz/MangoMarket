<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/sideMenu.css?after">
<div class="menu">
    <div class="sideMenu">
        <div class="menu1"><input type="radio" name="menu" value="0" id="popularity"><label for="popularity" class="btn"><img src="/resources/images/인기.png"></label><p class="menuT1">인기매물</p></div>
        <div class="menu2"><input type="radio" name="menu" value="1" id="digitalDevice"><label for="digitalDevice" class="btn"><img src="/resources/images/디지털기기.png"></label><p class="menuT2">디지털기기</p></div>
        <div class="menu3"><input type="radio" name="menu" value="2" id="interior"> <label for="interior" class="btn"><img src="/resources/images/가구_인테리어.png"></label><p class="menuT3">가구/인테리어</p></div>
        <div class="menu4"><input type="radio" name="menu" value="3" id="child"><label for="child" class="btn"><img src="/resources/images/유아.png"></label><p class="menuT4">유아동</p></div>
        <div class="menu5"><input type="radio" name="menu" value="4" id="usedCar"><label for="usedCar" class="btn"><img src="/resources/images/중고차.png"></label><p class="menuT5">중고차</p></div>
        <div class="menu6"><input type="radio" name="menu" value="5" id="book"><label for="book" class="btn"><img src="/resources/images/도서.png"></label><p class="menuT6">도서</p></div>
        <div class="menu7"><input type="radio" name="menu" value="6" id="ticket"><label for="ticket" class="btn"><img src="/resources/images/티켓_교환권.png"></label><p class="menuT7">티켓/교환권</p></div>
        <div class="menu8"><input type="radio" name="menu" value="7" id="pet"><label for="pet" class="btn"><img src="/resources/images/반려동물용품.png"></label><p class="menuT8">반려동물용품</p></div>
        <div class="menu9"><input type="radio" name="menu" value="8" id="etc"><label for="etc" class="btn"><img src="/resources/images/기타.png"></label><p class="menuT9">기타 중고물품</p></div>
        <div class="menu10"><input type="radio" name="menu" value="9" id="buy"><label for="buy" class="btn"><img src="/resources/images/삽니다.png"></label><p class="menuT10">삽니다</p></div>
    </div>
</div>
<input type="hidden" name="menuValue" value="">
<button id="Gobtn" onclick="document.location.href='writePost'">게시글 올리기 →</button>
