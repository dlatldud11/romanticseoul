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
		location.href='<%=contextPath%>/menuList.pr';
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
							 <form:select name="gulists"  path="gulists">
							    <form:option value="NONE"> --SELECT--</form:option>
							    <form:options items="${gulists}" itemLabel="mykey" itemValue="mykey"></form:options>
							  </form:select>
							 </div>
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">--- category ---
									<option value="eat">eat
									<option value="drink">drink
									<option value="look">look
								</select>
							</div>
							<div class="form-group">
							 <select id="good">
								<option>좋아하는 멤버를 선택해주세요</option>
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
						<th>category</th>
						<th>name</th>
						<th>address</th>
						<th>view detail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${storelists}">
						<tr>
						<td>${bean.category}</td>
						<td>${bean.name}</td>
						<td>${bean.address2}</td>
						<td>
						<a href="<%=contextPath%>/menuDetailView.pr?storeseq=${bean.storeseq}&mode=${mode2}&${requestScope.parameters}">
						상세보기
						</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
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
<script>
function categoryChange(e) {
	var eat = ${eatlists};
	var drink = ${drinklists};
	var look = ${looklists};
	var target = document.getElementById("mode");

	if(e.value == "eat") var d = eat;
	else if(e.value == "drink") var d = drink;
	else if(e.value == "look") var d = look;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d.mykey;
		opt.innerHTML = d.mykey;
		target.appendChild(opt);
	}	
}
</script>
</html>