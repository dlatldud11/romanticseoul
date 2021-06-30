<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String contextPath = request.getContextPath() ;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table>
			<c:forEach var="bean" items="${eatlists}">
			<tr>
			<th>먹을거리 가게 기본키</th>
			<td>${bean.eatid}</td>
			</tr>
			</c:forEach>
		</table>
		<table>
			<c:forEach var="bean" items="${looklists}">
			<tr>
			<th>먹을거리 가게 기본키</th>
			<td>${bean.lookid}</td>
			</tr>
			</c:forEach>
		</table>
		<table>
			<c:forEach var="bean" items="${drinklists}">
			<tr>
			<th>먹을거리 가게 기본키</th>
			<td>${bean.drinkid}</td>
			</tr>
			</c:forEach>
		</table>
		<table>
			<c:forEach var="bean" items="${eatgulists}">
			<tr>
			<th colspan="2">구별 먹거리 가게</th>
			</tr>
			<tr>
				<th>업태구분</th>
				<th>상세영업상태명</th>
				<th>지번주소</th>
				<th>도로명주소</th>
				<th>전화번호</th>
				<th>상세영업상태명</th>
				<th>도로명우편번호</th>
			</tr>
			<tr>
				<td>${bean.category}</td>
				<td>${bean.name}</td>
				<td>${bean.address1}</td>
				<td>${bean.address2}</td>
				<td>${bean.hp}</td>
				<td>${bean.remark}</td>
				<td>${bean.zipcode}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>