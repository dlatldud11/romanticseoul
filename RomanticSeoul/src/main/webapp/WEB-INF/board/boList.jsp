<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String contextPath = request.getContextPath() ;
%>    
<!DOCTYPE html>
<html lang="zxx">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"></script>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Directing Template">
    <meta name="keywords" content="Directing, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Directing | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700;800&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
        <!-- Js Plugins -->
    <script src="js/skycons.js"></script>
    <script src="js/app.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.barfiller.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7da2934f8df298719b719361891e59fa"></script>
    
</head>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row" style="justify-content: center;">
<div class="listing__details__comment">
                <h4>Comment</h4>
                <c:forEach var="bean" items="${lists}">
                <div class="listing__details__comment__item">
                    <div class="listing__details__comment__item__pic">
                        <img src="img/listing/details/comment.png" alt="">
                    </div>
                    <div class="listing__details__comment__item__text">
                        <div class="listing__details__comment__item__rating">
                            <c:if test="${bean.id eq sessionScope.loginfo.id}">
		                            <button type="button" onclick="openUpdate(${bean.boseq},'${bean.content}' )">
		                            ??????
		                            </button>
                            	</c:if>
                            	<c:if test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
		                            <button type=button onclick="location.href='<%=contextPath%>/bodelete.bo?boseq=${bean.boseq}'">??????</button>
                            	</c:if>
                            <!-- <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i> -->
                        </div>
                        <span>${bean.regdate}</span>
                        <h5>${bean.nickname}</h5>
                        <p>${bean.id}</p>
                        <div id="UpdateContent${bean.boseq}">
                        <p>${bean.content}</p>
                        </div>
                        <div id="insertReply">
                        <ul> 
                            <li>
                            <i class="fa fa-hand-o-right"></i> Like
                            </li>
                            <li>
                            <!-- <div data-toggle="collapse" data-target="#demo"> -->
                            <i id="comment" name="comment" class="fa fa-share-square-o"data-toggle="collapse" data-target="#demo${bean.boseq}"></i> 
                            Reply
                            </li>
                        </ul>
							  <div id="demo${bean.boseq}" class="collapse">
							    <c:forEach var="bean2" items="${relists}">
							    <c:if test="${bean.boseq eq bean2.boseq}">
							    <!-- ???????????? -->
							    <div class="listing__details__comment__item">
                    			<div class="listing__details__comment__item__pic">
                        		<img src="img/listing/details/comment.png" alt="">
                    			</div>
                   				 <div class="listing__details__comment__item__text">
                       			 <div class="listing__details__comment__item__rating">
		                            	<c:if test="${bean.id eq sessionScope.loginfo.id}">
				                            <button type="button" onclick="openReUpdate(${bean2.replyseq},'${bean2.content}' )">
				                            ??????
				                            </button>
		                            	</c:if>
		                            	<c:if test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
				                            <button type=button onclick="location.href='<%=contextPath%>/boRedelete.bo?replyseq=${bean2.replyseq}'">??????</button>
		                            	</c:if>
                            <!-- <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i> -->
                       			</div>
			                        <span>${bean2.regdate}</span>
			                        <h5>${bean2.nickname}</h5>
			                        <p>
			                        <c:choose>
			                        	<c:when test="${empty bean2.rid}">
					                        @${bean.nickname}
			                        	</c:when>
			                        	<c:otherwise>
			                        		@${bean2.rid}
			                        	</c:otherwise>
			                        </c:choose>
			                        </p>
			                        <div id="UpdateReContent${bean2.replyseq}">
			                        <p>${bean2.content}</p>
			                        </div>
			                        <div id="insertReply">
			                        <ul> 
			                            <li>
			                            <i class="fa fa-hand-o-right"></i> Like
			                            </li>
			                            <li>
			                            <!-- <div data-toggle="collapse" data-target="#demo"> -->
			                            <i id="comment" name="comment" class="fa fa-share-square-o"data-toggle="collapse" data-target="#demo"></i> 
			                            Reply
			                            </li>
			                        	</ul>
										  <div id="demo" class="collapse">
										    
										  </div>
			                        </div>
				                    </div>
				                </div>
							    <!-- ???????????? -->
							    </c:if>
							    </c:forEach>
							    <div class="listing__details__review">
							    <form:form id="myreform" name="myreform" modelAttribute="reply">
							    	<textarea id="content" name="content" placeholder="????????? ???????????????"></textarea>
							    	<input type = "hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
							    	<input type = "hidden" id="boseq" name="boseq" value="${bean.boseq}">
							    	<button type="button" onclick="submit2();">????????????</button>
							    </form:form>
							    </div>
							  </div>
                        </div> <!-- insertdata ??? -->
                    </div>
                </div>
            </c:forEach>
            <div class="listing__details__review">
                <h4>??????????????? ?????????</h4>
                <c:set var="apppath" value="<%=request.getContextPath()%>" />
         		<form:form id="myform" name="myform" modelAttribute="boardBoard" >
         		<%-- <form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo"> --%>
                    <input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
                    <input type="text" id="nickname" name="nickname" value="${sessionScope.loginfo.nickname}" readonly
                    placeholder="${sessionScope.loginfo.nickname}">
                    <!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
                    <textarea placeholder="???????????? ???????????????" id="content" name="content"></textarea>
                    <button id="btn_register" name="btn_register" type="button" class="site-btn" onclick="submit1();">Submit Now</button>
                    <button id="btn_previous" name="btn_register" type="button" class="site-btn" onclick="redirect();">????????????</button>
                </form:form>
            </div>
        </div>
    </div>
  </div>
<script>  
var mod_check = 'N';
var reply_check = 'N';
 	
 	function openUpdate(boseq, content){
 		
 		if(mod_check == 'Y')
			{
				alert('?????? ????????????.');
				return;
			}
 		document.getElementById('UpdateContent'+boseq).innerHTML = "<form id='mynewform' name='mynewform'>"
 		+"<div class='form-row'>"
 		+"<textarea name='content' id='content'>"+ content +"</textarea></div>"
 		+"<input type='hidden' id='boseq' name='boseq' value='" + boseq +"'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' onclick='location.reload()' value='??????'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' value='????????????' onclick='test()'>" 
 		+"</form>";
 		
 		mod_check = 'Y';
 	}
 	
 	
 	
 	function openReUpdate(boseq, content){
 		
 		if(reply_check == 'Y')
			{
				alert('?????? ??????????????????.');
				return;
			}
 		document.getElementById('UpdateReContent'+boseq).innerHTML = "<form id='myrenewform' name='myrenewform'>"
 		+"<div class='form-row'>"
 		+"<textarea name='content' id='content'>"+ content +"</textarea></div>"
 		+"<input type='hidden' id='replyseq' name='replyseq' value='" + boseq +"'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' onclick='location.reload()' value='??????'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' value='????????????' onclick='test()'>" 
 		+"</form>";
 		
 		reply_check = 'Y';
 	}	

</script>
<script>
function deleteone(){
	//ajax??? ???????????? ??????????????? ???????????????
	//enctype, processData, contentType ??? ???????????? ????????? ??????????????????.
	$.ajax({
		url : "<%=contextPath%>/bodelete.bo",
	data : {
		boseq : $('#boseq').val();
	}
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('????????? ?????? ??????');
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
	//ajax??? ???????????? ??????????????? ???????????????
	//enctype, processData, contentType ??? ???????????? ????????? ??????????????????.
	$.ajax({
		url : "<%=contextPath%>/boInsert.bo",
	data : $('#myform').serialize(),
	type : "POST",
	datatype : 'json',
	success : function() {
		alert('????????? ?????? ??????');
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
<script>
function submit2(){
	alert('submit2 ??????');
	// ?????? ??????
	$.ajax({
		url : "<%=contextPath%>/boReInsert.bo",
	data : $('#myreform').serialize(),
	type : "POST",
	datatype : 'json',
	success : function() {
		alert('?????? ?????? ??????');
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
<script>
//?????? ?????? ??? testList??? ??????
function redirect() {
	$(location).attr('href', '<%=contextPath%>/main.co');
}
function test(){
	//ajax??? ???????????? ??????????????? ???????????????
	//enctype, processData, contentType ??? ???????????? ????????? ??????????????????.
	var params = $("#mynewform").serialize();
	
	$.ajax({
		url : "<%=contextPath%>/boUpdate.bo",
	data : $("#mynewform").serialize(),
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('????????? ?????? ??????');
		console.log(data);
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
</body>
</html>