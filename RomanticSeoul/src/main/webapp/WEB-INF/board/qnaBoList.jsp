<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
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
</head>
<body>
	<section class="ftco-section">
		<div class="container">
		<h2>문의 게시판</h2>
			<table>
				<thead>
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>TITLE</th>
						<th>WRITEDATE</th>
						<th>CHECKS</th>
						<th>MODIFY</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.qnaseq}</td>
							<td><a href="boDetailView&bno=${bean.id}">
									${bean.title} </a></td>
							<td>${bean.checks}</td>
							<td><c:if test="${sessionScope.loginfo.id == bean.writer}">
									<a
										href="boUpdate&bno=${bean.bno}&${requestScope.parameters}">
										Update </a>
								</c:if></td>
							<td><c:if
									test="${sessionScope.loginfo.id == bean.writer || sessionScope.loginfo.id == 'admin' }">
									<a
										href="boDelete&bno=${bean.bno}&${requestScope.parameters}"
										onclick="return confirm('삭제하시겠습니까?');"> Delete </a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="button" align="right">
				<a href="boInsert" class="btn btn-primary py-2 px-4">Write</a>
			</div>

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