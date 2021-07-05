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
form.form-inline{
	justify-content: center;
}
</style>
	<script type="text/javascript">
		function writeForm(){
			location.href='<%=contextPath%>/menuInsert.pr';
		}
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;				
			}
		}
		function searchAll(){
			location.href='<%=contextPath%>/menuList.pr';
		}
	
	</script>
</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<h2>Menu</h2>
			<table>
				<thead>
					<tr>
						<th>image</th>
						<th>mname</th>
						<th>price</th>
						<th>remark</th>
					</tr>
				</thead>
				<tr>
					<td colspan="12" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="get">
							<c:if test="${whologin == 2}">
								<button class="btn btn-default btn-info" type="button"
									onclick="writeForm();">상품 등록</button>
							</c:if>	
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
				</tr>				
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td>${bean.image}</td>
					<td>${bean.mname}</td>
					<td>${bean.price}</td>
					<td>${bean.remark}</td>
					<td>
						<c:if test="${whologin == 2}">
							<a href="<%=contextPath%>/delete.pr?num=${bean.num}&${requestScope.parameters}">
								삭제
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							삭제
						</c:if>				
					</td>
					<td>
						<c:if test="${whologin == 2}">
							<a href="<%=contextPath%>/update.pr?num=${bean.num}&${requestScope.parameters}">
								수정
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							수정
						</c:if>	
						
					</td>
					</tr>
				</c:forEach>	
			</table>
			</div>
			<div class="block-27">
				<footer>${requestScope.pagingHtml}</footer>
			</div>
	</section>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>