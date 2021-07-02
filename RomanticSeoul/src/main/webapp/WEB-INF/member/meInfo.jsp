<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = 12 - 2 * offset ;
	int leftside = 4 ;
	int rightside = 12 - leftside ;
	
	
%> 
<!DOCTYPE html><html>
<head>
	<script>
	function gotoBack(){
		location.href='<%=contextPath%>/main.co?${requestScope.parameters}';
	}
	function gotoUpdate(){
		location.href='<%=contextPath%>/update.me?id=${sessionScope.loginfo.id}';
	}
	function gotoDelete(){
		location.href='<%=contextPath%>/delete.me?id=${sessionScope.loginfo.id}';
	}
	</script>
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>내 정보 상세보기</h4>
			</div>
			<div class="row panel-body">
				<div class="col-sm-4">
					<table>
						<tr>
							<td>
								<img src="${bean.image}" class="img-rounded" 
									alt="${bean.id}" width="300" height="300">		
							</td>
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
							<td width="25%" align="center">비밀번호</td>
							<td width="75%" align="left">${bean.password}</td>
						</tr>
						<tr>
							<td width="25%" align="center">이름</td>
							<td width="75%" align="left">${bean.name}</td>
						</tr>
						<tr>
							<td width="25%" align="center">닉네임</td>
							<td width="75%" align="left">${bean.nickname}</td>
						</tr>
						<tr>
							<td width="25%" align="center">이메일</td>
							<td width="75%" align="left">${bean.email}</td>
						</tr>
						<tr>
							<td width="25%" align="center">주소1</td>
							<td width="75%" align="left">${bean.address1}</td>
						</tr>
						<tr>
							<td width="25%" align="center">주소2</td>
							<td width="75%" align="left">${bean.address2}</td>
						</tr>
						<tr>
							<td width="25%" align="center">휴대전화</td>
							<td width="75%" align="left">${bean.hp}</td>
						</tr>
						<tr>
							<td width="25%" align="center">마시기</td>
							<td width="75%" align="left">${bean.drink}</td>
						</tr>
						<tr>
							<td width="25%" align="center">먹기</td>
							<td width="75%" align="left">${bean.eat}</td>
						</tr>
						<tr>
							<td width="25%" align="center">놀기</td>
							<td width="75%" align="left">${bean.play}</td>
						</tr>
						<tr>
							<td width="25%" align="center">걷기</td>
							<td width="75%" align="left">${bean.walk}</td>
						</tr>
						<tr>
							<td width="25%" align="center">보기</td>
							<td width="75%" align="left">${bean.look}</td>
						</tr>
					</table>
				</div>
			</div>
			<hr>
			<div class="col-sm-7" style="float:right;">
				<button class="btn btn-success" onclick="gotoMeList;">
					내 글 보기
				</button>
				<button class="btn btn-info" onclick="gotoUpdate();">
					회원 수정
				</button>
				<button type="button" onclick="gotoDelete();"  class="btn btn-danger">
					회원 삭제
				</button>
				<button class="btn btn-primary" onclick="gotoBack();">
					돌아 가기
				</button>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>