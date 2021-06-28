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
	function search(){
		if( $('#mode').val() == 'all' ){
			alert('검색 목록을 선택해주세요') ;
			//$('#mode').focus();
		}else{
			//alert('하하') ;
		}
		//alert( $('#mode').val() );
	}
	function searchAll(){
		//$('#mode').val('-');
		//$('#keyword').val('');
		location.href='<%=contextPath%>/qnaBoList.bo';
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
						<th>UPDATE</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.qnaseq}</td>
							<td>${bean.id}</td>
							<td>
							<a href="<%=contextPath%>/qnaDetailView.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
								${bean.title}
							</a>
							</td>
							<td>${bean.regdate}</td>
							<td>${bean.checks}</td>
							<td>
							<c:if test="${sessionScope.loginfo.id == bean.id}">
								<a href="<%=contextPath%>/qnaBoUpdate.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
									UPDATE
								</a>
							</c:if>
						</td>
						<td>
							<c:if test="${sessionScope.loginfo.id == bean.id or sessionScope.loginfo.id == 'admin'}">
								<a href="<%=contextPath%>/qnaBoDelete.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
									DELETE
								</a>
							</c:if>
						</td>
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
						<footer>${requestScope.pagingHtml}</footer>
					</div>
				</div>
			</div>
		</div>
		<br>
	</section>
	<script type="text/javascript">
	   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val( '${requestScope.keyword}' ) ;		
	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>