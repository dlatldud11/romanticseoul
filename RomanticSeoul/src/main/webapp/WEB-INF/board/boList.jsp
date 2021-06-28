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
                        <!-- <div class="listing__details__comment__item__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div> -->
                        <span>${bean.regdate}</span>
                        <h5>${bean.nickname}</h5>
                        <p>${bean.content}</p>
                        <ul>
                            <li><i class="fa fa-hand-o-right"></i> Like</li>
                            <li><i class="fa fa-share-square-o"></i> Reply</li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
            <div class="listing__details__review">
                <h4>자유게시판 글쓰기</h4>
                <c:set var="apppath" value="<%=request.getContextPath()%>" />
         		<form id="myform" name="myform">
         		<%-- <form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo"> --%>
                    <input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
                    <input type="text" id="nickname" name="nickname" value="${sessionScope.loginfo.nickname}" readonly
                    placeholder="${sessionScope.loginfo.nickname}">
                    <!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
                    <textarea placeholder="글내용을 작성하세요" id="content" name="content"></textarea>
                    <button id="btn_register" name="btn_register" type="button" class="site-btn" onclick="submit1();">Submit Now</button>
                    <button id="btn_previous" name="btn_register" type="button" class="site-btn" onclick="redirect();">뒤로가기</button>
                </form>
            </div>
        </div>
    </div>
  </div>
  <form>
		아이디:<input type="text" id="checkid"><br> <br>
		<button type="button" id="_check" >id 체크</button>
	</form>

	<script>
	
		function idcheck() {
			alert("idCheck");

			$.ajax({
				url : "./idCheck.do",
				type : "get",
				data : "id=" + $("#checkid").val(),
				success : function(data) {
					alert("되요ㅋ");
					alert(data);
				},
				error : function() {
					alert("에러나요");
				}
			})
		}
	</script>
<script>
//글쓰기
function submit2(){
	alert('submit2 실행');
}
function submit1(){
	alert('submit 실행');
	if ($('#content') == null) {
		alert('내용을 입력해주세요.');
		return;
	}

	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	$.ajax({
		/* enctype : 'multipart/form-data',
		processData : false,
		contentType : false, 
		cache : false, */
		url : "<%=contextPath%>/boInsert.bo",
	data : $('#myform').serialize(),
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 등록 완료');
		console.log(data);
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}

//이전 클릭 시 testList로 이동
function redirect() {
	$(location).attr('href', '<%=contextPath%>/main.co');
}
</script>
</body>
</html>