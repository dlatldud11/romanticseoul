<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

결과물 순위권으로 나타내기<br>
<hr>
일등한 가게<br>
<c:forEach var="bean" items="${first}">
<c:if test="${bean.storeseq eq firsttop }">
	${bean.name}<br>
	${bean.storeseq}<br>
	${bean.category}<br>
	${bean.address2}<br>
</c:if>
</c:forEach><br>
<c:forEach var="bean" items="${second}">
<c:if test="${bean.storeseq eq secondtop}">
	${bean.name}<br>
	${bean.storeseq}<br>
	${bean.category}<br>
	${bean.address2}
</c:if>
</c:forEach><br>
<hr>
그다음 가게<br>
<c:forEach var="bean" items="${first}">
<c:forEach var="bean2" items="${firstrank}">
<c:if test="${bean.storeseq eq bean2}">
	${bean.name}<br>
	${bean.storeseq}<br>
	${bean.category}<br>
	${bean.address2}
</c:if>
</c:forEach>
</c:forEach>
<c:forEach var="bean" items="${second}">
<c:forEach var="bean2" items="${secondrank}">
<c:if test="${bean.storeseq eq bean2}">
	${bean.name}<br>
	${bean.storeseq}<br>
	${bean.category}<br>
	${bean.address2}
</c:if>
</c:forEach>
</c:forEach>
</body>
</html>