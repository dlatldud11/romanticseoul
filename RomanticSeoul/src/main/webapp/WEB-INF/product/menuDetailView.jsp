<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html lang="zxx">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"></script>

<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function gotoBack(){
	location.href='<%=contextPath%>/menuList.pr?${requestScope.parameters}';
	}
</script>
</head>
<div class="panel-heading">
	<h2 class="panel-title" align="left">매뉴</h2>
</div>
<div class="row panel-body">
	<div class="col-sm-8">
		<table class="table table-bordered">
			<tr>
				<td width="25%" align="center">이미지</td>
				<td width="75%" align="left">${bean.image}</td>
			</tr>
			<tr>
				<td width="25%" align="center">매뉴 이름</td>
				<td width="75%" align="left">${bean.mname}</td>
			</tr>
			<tr>
				<td width="25%" align="center">가격</td>
				<td width="75%" align="left">${bean.price}</td>
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
                            	<c:when test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
		                            <button class="btn btn-primary" type="button" onclick="openUpdate(${bean.storeseq},'${bean.recontent}' )">
		                            수정
		                            </button>
                            	</c:when>
                            	<c:when test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
		                            <button class="btn btn-danger" type=button onclick="location.href='<%=contextPath%>/menudelete.pr?storeseq=${bean.storeseq}'">삭제</button>
                            	</c:when>
                            </c:choose>
                        </div>
                        <span>${bean.reregdate}</span>
                        <p>관리자</p>
                        <div id="UpdateContent${bean.storeseq}">
                        <p>${bean.recontent}</p>
                        <div id="insertReply">
                        <ul> 
                            <li>
                            <i class="fa fa-hand-o-right"></i> Like
                            </li>
                            <li>
                            <i id="comment" name="comment" class="fa fa-share-square-o"data-toggle="collapse" data-target="#demo"></i> 
                            Reply
                            </li>
                        </ul>
                        </div>
                    </div>
                </div>
            <c:choose>
               	<c:when test="${sessionScope.loginfo.id eq 'admin'}">
            <div class="listing__details__review">
                <h4>자유게시판 글쓰기</h4>
                <c:set var="apppath" value="<%=request.getContextPath()%>" />
         		<form:form id="myform" name="myform" modelAttribute="Board" >
         		<%-- <form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo"> --%>
                    <input type="hidden" id="storeseq" name="storeseq" value="${bean.storeseq}">
                    <input type="text" id="id" name="id" value="${sessionScope.loginfo.id}" readonly
                    placeholder="${sessionScope.loginfo.nickname}">
                    <!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
                    <textarea placeholder="글내용을 작성하세요" id="recontent" name="recontent"></textarea>
                    <button id="btn_register" name="btn_register" type="button" class="site-btn" onclick="submit1();">Submit Now</button>
                    <button id="btn_previous" name="btn_register" type="button" class="site-btn" onclick="redirect();">뒤로가기</button>
                </form:form>
            </div>
            </c:when>
            </c:choose>
        </div>
    </div>
  </div>
  </div>
<script>  
var mod_check = 'N';
var reply_check = 'N';
 	
 	function openUpdate(storeseq, recontent){
 		
 		if(mod_check == 'Y')
			{
				alert('수정 중입니다.');
				return;
			}
 		document.getElementById('UpdateContent'+storeseq).innerHTML = "<form id='mynewform' name='mynewform'>"
 		+"<div class='form-row'>"
 		+"<textarea name='recontent' id='recontent'>"+ recontent +"</textarea></div>"
 		+"<input type='hidden' id='storeseq' name='storeseq' value='" + storeseq +"'>"
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
		url : "<%=contextPath%>/menudelete.pr",
	data : {
		storeseq : $('#storeseq').val();
	}
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 삭제 완료');
		console.log(data);
		location.href = "<%=contextPath%>/menuList.pr";
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
	
	var storeseq = $('input#storeseq').val();	
	$.ajax({
			url : "<%=contextPath%>/menuReply.pr",
		data : $('#myform').serialize(),
		type : "POST",
		datatype : 'json',
		success : function(data) {
			alert('답변 등록 완료');
			console.log(data);
			location.href = "<%=contextPath%>/menuDetailView.pr?storeseq="+storeseq;
			},
		eroor:function(request,status,error){
			alert('error');
		}
	});
}
function redirect() {
	$(location).attr('href', '<%=contextPath%>/menuList.bo');
}
function test(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	var params = $("#mynewform").serialize();
	
	$.ajax({
		url : "<%=contextPath%>/menuReply.bo",
	data : $("#mynewform").serialize(),
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 수정 완료');
		console.log(data);
		location.href = "<%=contextPath%>/menuDetailView.pr?menuseq="+menuseq;
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
<jsp:include page="../common/footer.jsp" />