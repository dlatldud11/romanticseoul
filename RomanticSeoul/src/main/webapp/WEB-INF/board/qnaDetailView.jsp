<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<script type="text/javascript">
function gotoBack(){
	location.href='<%=contextPath%>/qnaBoList.bo?${requestScope.parameters}';
}
</script>
<div class="panel-heading">
	<h2 class="panel-title" align="left">게시물 상세 보기</h2>
</div>
<div class="panel-body">
	<div class="col-sm-6 col-sm-6">
		<table class="table table-hover table-condensed">
			<tr>
				<td width="25%" align="center">글 번호</td>
				<td width="75%" align="left">${bean.qnaseq}</td>
			</tr>
			<tr>
				<td width="25%" align="center">작성자</td>
				<td width="75%" align="left">${bean.id}</td>
			</tr>
			<tr>
				<td width="25%" align="center">제목</td>
				<td width="75%" align="left">${bean.title}</td>
			</tr>
			<tr>
				<td width="25%" align="center">글 내용</td>
				<td width="75%" align="left">${bean.content}</td>
			</tr>
			<tr>
				<td width="25%" align="center">작성 일자</td>
				<td width="75%" align="left">${bean.regdate}</td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="col-sm-offset-5 col-sm-4">
		<button class="btn btn-primary" onclick="gotoBack();">돌아 가기</button>
	</div>
</div>
<jsp:include page="../common/footer.jsp" />