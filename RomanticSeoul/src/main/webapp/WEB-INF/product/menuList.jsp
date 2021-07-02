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
		location.href='<%=contextPath%>/menuInsert.pr';
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
		location.href='<%=contextPath%>/menuList.bo';
	}
</script>
<style>
form.form-inline{
	justify-content: center;
}
</style>
</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<h2>What Shall We Do Today?</h2>
			<table>
				<thead>
				<tr>
					<td colspan="10" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=contextPath%>/menuList.pr" method="get">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">--- Area ---
								</select>
							</div>
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">--- CATEGORY --- 									
								</select>
								
							</div>
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">--- category ---
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
					</tr>
					<tr>
						<th>NO</th>
						<th>AREA</th>
						<th>CATEGORY</th>
						<th>STORE NAME</th>
						<th>VIEW</th>
					</tr>
				</thead>
				<tr>
					
				</tr>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.qnaseq}</td>
							<td>${bean.id}</td>
							<td>
							<a href="<%=contextPath%>/menuView.pr?menuseq=${bean.menuseq}&${requestScope.parameters}">
								${bean.title}
							</a>
							</td>
							<td>${bean.regdate}</td>
							<td>${bean.checks}</td>
							<td>
							<c:if test="${sessionScope.loginfo.id == bean.id}">
								<a href="<%=contextPath%>/menuUpdate.bo?menuseq=${bean.menuseq}&${requestScope.parameters}">
									UPDATE
								</a>
							</c:if>
						</td>
						<td>
							<c:if test="${sessionScope.loginfo.id == bean.id or sessionScope.loginfo.id == 'admin'}">
								<a href="<%=contextPath%>/menuDelete.bo?menuseq=${bean.menuseq}&${requestScope.parameters}">
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
			</div>
			<div class="block-27">
				<footer>${requestScope.pagingHtml}</footer>
			</div>
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