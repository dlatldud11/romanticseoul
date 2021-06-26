<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 부트 스트랩 -->
<%-- <% int twelve = 12 ; %>
	<c:set var="twelve" value="12" />
<%
	int myoffset = 3;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%> --%>
<div class="container">
	<div class="row" style="justify-content: center;">
		<div class="panel panel-default panel-warning">
			<h2 class="panel-heading" >로그인 하기</h2>
			<div class="panel-body">
				<form class="form-horizontal" role="form"
					action="<%=contextPath%>/meLoginForm.me" method="post">
					<div class="form-group">
						<label class="control-label" for="id">아이디</label>
						<div class="col-sm-12">
							<input type="text" class="form-control" name="id" id="id"
								data-toggle="tooltip" data-placement="top"
								title="아이디는  4글자 이상 10글자 이하로 입력해 주세요."
								placeholder="아이디를 넣어 주셔용^^"> <span class="err">${errid}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="password">비밀 번호</label>
						<div class="col-sm-12">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="비밀 번호도 고고^^"> <span
								class="err">${errpassword}</span>
						</div>
					</div>
					<div class="form-group">
						<div align="center" class="">
							<button class="btn btn-default" type="submit">로그인</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">취소</button>
							<br>
							<a href="./insert.me">회원가입</a>
								<br>
								<a href="./findId.me">아이디 찾기</a>
							<a href="">비밀번호 찾기</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<%@ include file="../common/footer.jsp"%>