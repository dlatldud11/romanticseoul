<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- whologin 변수는 로그인 상태를 저장하고 있는 변수입니다. -->
<c:set var="whologin" value="0" />
<c:if test="${empty sessionScope.loginfo}">
	<!-- 로그인 하지 않은 경우 -->
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.id == 'admin'}">\
		<!-- 관리자로 로그인한 경우 -->
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${sessionScope.loginfo.id != 'admin'}">
		<!-- 일반 사용자로 로그인한 경우 -->
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>

<!-- 부트 스트랩 -->
<% int twelve = 12 ; %>
	<c:set var="twelve" value="12" />
<%
	int myoffset = 3;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-warning">
			<div class="panel-heading">로그인 하기</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="/meLogin.me" method="post">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="id">아이디</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="id" id="id"
								data-toggle="tooltip" data-placement="top" 
								title="아이디는  4글자 이상 10글자 이하로 입력해 주세요."
								placeholder="아이디를 넣어 주셔용^^">
								<span class="err">${errid}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="password">비밀 번호</label>
						<div class="col-sm-<%=formright%>">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="비밀 번호도 고고^^">
							<span class="err">${errpassword}</span>
						</div>
					</div>
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">로그인</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">취소</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/meinsert.me">회원 가입</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="">아이디 찾기</a>
							/
							<a href="">비밀번호 찾기</a>							
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();    		
		});
	</script>
	<%@ include file="../common/footer.jsp"%>