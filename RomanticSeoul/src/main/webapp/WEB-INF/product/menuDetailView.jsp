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
			if(${mode == 'eat'}){
			location.href='<%=contextPath%>/menuInsert.pr?eatid='${bean.eatid}.val();
			}
			if(${mode == 'drink'}){
			location.href='<%=contextPath%>/menuInsert.pr?drinkid='${bean.drinkid}.val();
			}
			if(${mode == 'look'}){
			location.href='<%=contextPath%>/menuInsert.pr?lookid='${bean.lookid}.val();
			}
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
			<h2>${mode}</h2>
			<table>
				<thead>
					<tr>
						<th>IMAGE</th>
						<th>NAME</th>
						<th>PRICE</th>
						<th>QTY</th>
						<th>DRINKID</th>
						<th>EATID</th>
						<th>LOOKID</th>
						<th>START</th>
						<th>END</th>
						<th>REMARK</th>
						<th>DELETE</th>
						<th>UPDATE</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${lists}">
				<tr>
					<td>${bean.image}</td>
					<td>${bean.mname}</td>
					<td>${bean.price}</td>
					<td>${bean.qty}</td>
					<td>${bean.drinkid}</td>
					<td>${bean.eatid}</td>
					<td>${bean.lookid}</td> 
					<td>${bean.starts}</td>
					<td>${bean.ends}</td>
					<td>${bean.remark}</td>
					<td>
						<c:if test="${whologin == 2}">
							<a href="<%=contextPath%>/menuDelete.pr?menuseq=${bean.menuseq}&${requestScope.parameters}">
								삭제
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							삭제
						</c:if>				
					</td>
					<td>
						<c:if test="${whologin == 2}">
							<a href="<%=contextPath%>/menuUpdate.pr?menuseq=${bean.menuseq}&${requestScope.parameters}">
								수정
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							수정
						</c:if>	
					</td>
					</tr>
				<%-- storeseq mode에 따라서 보내는 값 다르게 해주기 --%>
				</c:forEach>
				
				<c:if test="${whologin == 2}">
					<a href="<%=contextPath%>/menuInsert.pr?storeseq=${storeseq}&mode=${mode}&${requestScope.parameters}">상품 등록</a>
					<!-- <button class="btn btn-primary">
					</button> -->
					<%-- <button class="btn btn-default btn-info" type="button"
						onclick="<%=contextPath%>/menuInsert.pr?storeseq=${storeseq}">상품 등록</button> --%>
				</c:if>	
					<%-- <p class="form-control-static">${requestScope.pagingStatus}</p> --%>
			</table>
			</div>
			<div class="block-27">
				<footer>${requestScope.pagingHtml}</footer>
			</div>
	</section>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>