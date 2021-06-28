<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
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
									alt="${bean.id}" width="500" height="500">		
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
					</table>
				</div>
			</div>
			<hr>
			<div class="col-sm-7" style="float:right;">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>memberUpdate&id=${bean.id}'">
					회원 수정
				</button>
				<button type="button" onclick="window.location.href='<%=NoForm%>memberDelete&id=${bean.id}'"  class="btn btn-danger">
					회원 삭제
				</button>
				<button class="btn btn-primary" onclick="gotolist();">돌아 가기</button>
			</div>
		</div>
	</div>
</body>
</html>