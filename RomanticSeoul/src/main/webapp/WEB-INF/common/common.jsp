<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- whologin 변수는 로그인 상태를 저장하고 있는 변수입니다. -->
<c:set var="whologin" value="0" />
<c:if test="${empty sessionScope.loginfo}">
	<!-- 로그인 하지 않은 경우 -->
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.id == 'admin'}">
		<!-- 관리자로 로그인한 경우 -->
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${sessionScope.loginfo.id != 'admin'}">
		<!-- 일반 사용자로 로그인한 경우 -->
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>

<%!
	String YesForm = null ;
	String NoForm = null ;
%>
<%
String contextPath = request.getContextPath();
String mappingName = "/main";
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Directing Template">
<meta name="keywords" content="Directing, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Romantic Seoul</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700;800&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/flaticon.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/barfiller.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-md-3">
					<div class="location">
						<!-- <h2 class="location-timezone">Timezone</h2> -->
						<canvas class="icon" width="80" height="80"></canvas>
						<div class="temperature">
							<div class="degree-section">
								<h2 class="temperature-degree"><span>CLICK</span></h2>
							</div>
							<!-- <div class="temperature-description">Its friggin cold</div> -->
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-9">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>
								<li class="active"><a href="./main.co">홈</a></li>
								<li><a href="./boList.bo">자유게시판</a></li>
								<li><a href="./coBoList.bo">코스후기</a></li>
								<li><a href="./zzimList.ma">찜</a></li>
								<li><a href="./qnaBoList.bo">문의하기</a></li>
								<c:if test="${whologin == 2}">
									<li><a href="./adminPage.me">관리자</a></li>
								</c:if>
							</ul>
						</nav>
						<div class="header__menu__right">
						<c:choose>
							<c:when test="${whologin == 0 }">
							<a href="./meLoginForm.me" class="primary-btn"><i class="fa fa-plus"></i> 로그인</a> 
							</c:when>
							<c:when test="${whologin != 0 }">
							<a href="./meLogout.me" class="primary-btn"><i class="fa fa-plus"></i> 로그아웃</a> 
							</c:when>
						</c:choose>
							<a href="./meInfo.me?id=${sessionScope.loginfo.id}" class="login-btn"><i class="fa fa-user"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header Section End -->