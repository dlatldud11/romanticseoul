<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="row">
			<c:forEach var="bean" items="${lists}">
				<div class="listing__details__comment__item">
					<div class="listing__details__comment__item__pic">
						<img src="img/listing/details/comment.png" alt="">
					</div>
					<div class="listing__details__comment__item__text">
						<div class="listing__details__comment__item__rating">
							<c:choose>
								<c:when test="${bean.id eq sessionScope.loginfo.id}">
									<button type="button"
										onclick="openUpdate(${bean.boseq},'${bean.content}' )">
										수정</button>
								</c:when>
								<c:when
									test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
									<button type=button
										onclick="location.href='<%=contextPath%>/bodelete.bo?boseq=${bean.boseq}'">삭제</button>
								</c:when>
							</c:choose>
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
								<li><i class="fa fa-hand-o-right"></i> Like</li>
								<li>
									<!-- <div data-toggle="collapse" data-target="#demo"> --> <i
									id="comment" name="comment" class="fa fa-share-square-o"
									data-toggle="collapse" data-target="#demo"></i> Reply
								</li>
							</ul>
							<div id="demo" class="collapse">
								<!-- 댓글부분 -->
								<div class="listing__details__comment__item">
									<div class="listing__details__comment__item__pic">
										<img src="img/listing/details/comment.png" alt="">
									</div>
									<div class="listing__details__comment__item__text">
										<div class="listing__details__comment__item__rating">
											<c:choose>
												<c:when test="${bean.id eq sessionScope.loginfo.id}">
													<button type="button"
														onclick="openUpdate(${bean.boseq},'${bean.content}' )">
														수정</button>
												</c:when>
												<c:when
													test="${bean.id eq sessionScope.loginfo.id || sessionScope.loginfo.id eq 'admin'}">
													<button type=button
														onclick="location.href='<%=contextPath%>/bodelete.bo?boseq=${bean.boseq}'">삭제</button>
												</c:when>
											</c:choose>
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
												<li><i class="fa fa-hand-o-right"></i> Like</li>
												<li>
													<!-- <div data-toggle="collapse" data-target="#demo"> --> <i
													id="comment" name="comment" class="fa fa-share-square-o"
													data-toggle="collapse" data-target="#demo"></i> Reply
												</li>
											</ul>
											<div id="demo" class="collapse"></div>
										</div>
									</div>
								</div>
								<!-- 댓글부분 -->
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="listing__details__review">
				<h4>COMMENT</h4>
				<c:set var="apppath" value="<%=request.getContextPath()%>" />
				<form:form id="myform" name="myform" modelAttribute="board">
					<textarea placeholder="글내용을 작성하세요" id="content" name="content"></textarea>
					<button id="btn_register" name="btn_register" type="button"
						class="site-btn" onclick="submit1();">Submit Now</button>
					<button id="btn_previous" name="btn_register" type="button"
						class="site-btn" onclick="redirect();">뒤로가기</button>
				</form:form>
			</div>
		</div>
	</div>
<script>
function submit1(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
	$.ajax({
		url : "<%=contextPath%>/qnaBoInsert.bo",
	data : $('#myform').serialize(),
	type : "POST",
	datatype : 'json',
	success : function(data) {
		alert('게시글 등록 완료');
		console.log(data);
		location.href = "<%=contextPath%>/qnaboList.bo";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>
</body>
</html>
