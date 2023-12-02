<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.jsp" %>
<%@ include file="include/sideMenu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>망고마켓</title>
<link rel="stylesheet" href="/resources/css/goodList.css?after">
<script src="https://kit.fontawesome.com/064e428fcd.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<div id="menuBox"></div>
<input type="hidden" id="menuValue" value="${menu }">
<section>
	<div id="disp"></div>
</section>

<script src="/resources/js/goodList.js"></script>
</body>
</html>
