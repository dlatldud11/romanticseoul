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
<script type="text/javascript">
//글쓰기
function submit(){

	//데이터를 담아내는 부분 상수 const로
	//jquery val() : Form Element 의 값을 받아오는데 쓰인다. (주로 input 이나 textarea 정도?)- 주의해야할 점은 Form Element 이외의 값은 받아오질 못한다는 점.
	//문자열 좌우에서 공백을 제거하는 함수가 trim() 함수 입니다.
	var id = document.myform.id.val().trim();
	var content = document.myform.content.val().trim();

	//'==' 연산자를 이용하여 서로 다른 유형의 두 변수의 [값] 비교
	//'==='는 엄격한 비교를 하는 것으로 알려져 있다 ([값 & 자료형] -> true). 변수를 비교하거나 어떤 비교를 위해 항상 '===' 연산자를 사용 할 것을 권장한다.

	if (testContent === '') {
		alert('내용을 입력해주세요.');
		return;
	}

	//ajax 통신을 사용해 서버에 데이터를 전송하기 위해 
	//폼데이터 객체를 생성함
	//jquery의 append를 통해서 프로퍼티에 바인딩이 가능하도록 세팅한다..append()선택된 요소의 마지막에 새로운 요소나 콘텐츠를 추가한다.
	var formData = new FormData();
	formData.append("id", id);
	formData.append("content", content);

	//만약 uploadFile이 undifined거나 null일 경우 폼데이터에 보내지 않도록 한다.
	//이부분 체크하지 않을 경우 undifined가 데이터로 보내지기 때문에 서버에서 에러가 발생한다.
	/* if (uploadFile)
		formData.append("uploadFile", uploadFile); */

	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	$.ajax({
		/* enctype : 'multipart/form-data',
		processData : false,
		contentType : false, */
		cache : false,
		url : "<%=contextPath%>/boInsert.bo",
	data : formData,
	type : "POST",
	success : function(res) {
		alert('게시글 등록 완료');
		location.href = "<%=contextPath%>/boList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
});

//이전 클릭 시 testList로 이동
function redirect() {
	$(location).attr('href', '<%=contextPath%>/main.co');
});
</script>
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
         		<form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo">
                    <input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
                    <input type="text" id="nickname" name="nickname" value="${sessionScope.longinfo.nickname}">
                    <!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
                    <textarea placeholder="글내용을 작성하세요" id="content" name="content"></textarea>
                    <button id="btn_register" name="btn_register" type="button" class="site-btn" onclick="submit();">Submit Now</button>
                    <button id="btn_previous" name="btn_register" type="button" class="site-btn" onclick="redirect();">뒤로가기</button>
                </form:form>
            </div>
        </div>
    </div>
  </div>
  <form>
		아이디:<input type="text" id="checkid"><br> <br>
		<button type="button" id="_check">id 체크</button>
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
</body>
</html>