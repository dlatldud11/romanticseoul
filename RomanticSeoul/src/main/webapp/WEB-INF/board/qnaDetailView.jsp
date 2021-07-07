<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function gotoBack(){
	location.href='<%=contextPath%>/qnaBoList.bo?${requestScope.parameters}';
	}
</script>
</head>
<div class="controller">
<div class="panel-heading">
	<h2 class="panel-title" align="center" style="margin:20px 0;">게시물 상세 보기</h2>
</div>
<div class="row panel-body" style="padding: 0 200px;">
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
	</div>
</div>
<div class="container">
	<div class="row" style="justify-content: center;">
		<div class="listing__details__comment">
			<h4>Comment</h4>
			<div class="listing__details__comment__item">
				<div class="listing__details__comment__item__pic">
					<img src="img/listing/details/comment.png" alt="">
				</div>
				<div class="listing__details__comment__item__text">
					<div class="listing__details__comment__item__rating">
						<c:choose>
							<%-- <c:when test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
		                            <button class="btn btn-primary" type=button onclick="location.href='<%=contextPath%>/boupdate.bo?qnaseq=${bean.qnaseq}'">수정</button>
                            	</c:when> --%>
							<c:when
								test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
								<button class="btn btn-danger" type=button
									onclick="location.href='<%=contextPath%>/bodelete.bo?qnaseq=${bean.qnaseq}'">삭제</button>
							</c:when>
						</c:choose>
					</div>
					<span>${bean.reregdate}</span>
					<p>관리자</p>
					<div id="UpdateContent${bean.qnaseq}">
						<p>${bean.recontent}</p>
						<div id="insertReply">
							<ul>
								<li><i class="fa fa-hand-o-right"></i> Like</li>
								<li><i id="comment" name="comment"
									class="fa fa-share-square-o" data-toggle="collapse"
									data-target="#demo"></i> Reply</li>
							</ul>
						</div>
					</div>
				</div>
				<c:choose>
					<c:when test="${sessionScope.loginfo.id eq 'admin'}">
						<div class="listing__details__review">
							<h4>자유게시판 글쓰기</h4>
							<c:set var="apppath" value="<%=request.getContextPath()%>" />
							<form:form id="myform" name="myform" modelAttribute="Board">
								<%-- <form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo"> --%>
								<input type="hidden" id="qnaseq" name="qnaseq"
									value="${bean.qnaseq}">
								<input type="text" id="id" name="id"
									value="${sessionScope.loginfo.id}" readonly
									placeholder="${sessionScope.loginfo.nickname}">
								<!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
								<textarea placeholder="글내용을 작성하세요" id="recontent"
									name="recontent"></textarea>
								<button id="btn_register" name="btn_register" type="button"
									class="site-btn" onclick="submit1();">Submit Now</button>
								<button id="btn_previous" name="btn_register" type="button"
									class="site-btn" onclick="redirect();">뒤로가기</button>
							</form:form>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>
</div>
<script>  
var mod_check = 'N';
var reply_check = 'N';
 	
 	function openUpdate(qnaseq, recontent){
 		
 		if(mod_check == 'Y')
			{
				alert('수정 중입니다.');
				return;
			}
 		document.getElementById('UpdateContent'+qnaseq).innerHTML = "<form id='mynewform' name='mynewform'>"
 		+"<div class='form-row'>"
 		+"<textarea name='recontent' id='recontent'>"+ recontent +"</textarea></div>"
 		+"<input type='hidden' id='qnaseq' name='qnaseq' value='" + qnaseq +"'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' onclick='location.reload()' value='취소'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' value='수정완료' onclick='test()'>" 
 		+"</form>";
 		
 		mod_check = 'Y';
 	}
</script>
<script>
function deleteone(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	$.ajax({
		url : "<%=contextPath%>/bodelete.bo",
	data : {
		qnaseq : $('#qnaseq').val();
	}
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 삭제 완료');
		console.log(data);
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
<script>
function submit1(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	
	var qnaseq = $('input#qnaseq').val();	
	$.ajax({
			url : "<%=contextPath%>/qnaBoReply.bo",
		data : $('#myform').serialize(),
		type : "POST",
		datatype : 'json',
		success : function(data) {
			alert('답변 등록 완료');
			console.log(data);
			location.href = "<%=contextPath%>/qnaDetailView.bo?qnaseq="+qnaseq;
			},
		eroor:function(request,status,error){
			alert('error');
		}
	});
}
function redirect() {
	$(location).attr('href', '<%=contextPath%>/qnaBoList.bo');
}
function test(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	var params = $("#mynewform").serialize();
	
	$.ajax({
		url : "<%=contextPath%>/qnaBoReply.bo",
	data : $("#mynewform").serialize(),
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 수정 완료');
		console.log(data);
		location.href = "<%=contextPath%>/qnaDetailView.bo?qnaseq="+qnaseq;
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
<jsp:include page="../common/footer.jsp" />