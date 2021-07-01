<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function gotoBack(){
		location.href='<%=contextPath%>/menuList.pr?${requestScope.parameters}';
	}
	function gotoUpdate(){
		location.href='<%=contextPath%>/menuUpdate.pr?id=${sessionScope.loginfo.id}';
	}
	function gotoDelete(){
		location.href='<%=contextPath%>/delete.me?id=${sessionScope.loginfo.id}';
	}
</script>
<div class="panel-heading">
	<h2 class="panel-title" align="left">매뉴 상세보기</h2>
</div>
<div class="row panel-body">
	<div class="col-sm-4">
		<table>
			<tr>
				<td><img src="${bean.image}" class="img-rounded"
					alt="${bean.id}" width="300" height="300"></td>
			</tr>
		</table>
	</div>
	<div class="col-sm-8">
		<table class="table table-bordered">
			<tr>
				<td width="25%" align="center">아이디</td>
				<td width="75%" align="left">${bean.id}</td>
			</tr>
			<tr>
				<td width="25%" align="center">제목</td>
				<td width="75%" align="left">${bean.title}</td>
			</tr>
			<tr>
				<td width="25%" align="center">내용</td>
				<td width="75%" align="left">${bean.content}</td>
			</tr>
			<tr>
				<td width="25%" align="center">날짜</td>
				<td width="75%" align="left">${bean.regdate}</td>
			</tr>
		</table>
		<div class="col-sm-7" style="float:right;">
				<button class="btn btn-info" onclick="gotoUpdate();">
					매뉴 수정
				</button>
				<button class="btn btn-primary" onclick="gotoBack();">
					돌아 가기
				</button>
				<button type="button" onclick="gotoDelete();"  class="btn btn-danger">
					매뉴 삭제
				</button>
			</div>
	</div>
</div>
<jsp:include page="../common/footer.jsp" />