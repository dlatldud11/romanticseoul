<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	$(function(){
		$("#loginBtn").click(function(){
			location.href='../member/findPw.me';
		})
	})
</script>
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<c:set var="apppath" value="<%=request.getContextPath()%>" />
			<form:form action="${apppath}/findPw.me" method="post">
				<div class="w3-center w3-large w3-margin-top">
					<h3>비밀번호 찾기</h3>
				</div>
				<div>
					<p>
						<label>ID</label>
						<input class="w3-input" type="text" id="id" name="id" required>
						<label>Email</label>
						<input class="w3-input" type="text" id="email" name="email" required>
					</p>
					<p class="w3-center">
						<button type="submit" id=findBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">find</button>
						<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
					</p>
				</div>
				
			</form:form>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>