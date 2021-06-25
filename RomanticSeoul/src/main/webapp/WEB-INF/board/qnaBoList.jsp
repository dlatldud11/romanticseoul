<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h2 {
	text-align: center;
	padding: 20px 0;
}

ul.pagination {
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	padding: 8px;
	text-align-last: center;
	border-bottom: 1px solid #ddd;
	color: black;
}

td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}
</style>
<script type="text/javascript">
		function writeForm(){
				location.href='<%=contextPath%>/qnaBoInsert.bo';
	}
</script>
</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<h2>문의하기</h2>
			<table>
				<thead>
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>TITLE</th>
						<th>WRITEDATE</th>
						<th>CHECKS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.qnaseq}</td>
							<td>${bean.id}</td>
							<td>${bean.title}</td>
							<td>${bean.regdate}</td>
							<td>${bean.checks}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<button class="btn btn-default btn-info" type="button"
				onclick="writeForm();">글쓰기</button>
			<br>
			<div class="row mt-5" align="center">
				<div class="col text-center">
					<div class="block-27">
						<footer>${pageInfo.pagingHtml}</footer>
					</div>
				</div>
			</div>
		</div>
		<br>
	</section>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>