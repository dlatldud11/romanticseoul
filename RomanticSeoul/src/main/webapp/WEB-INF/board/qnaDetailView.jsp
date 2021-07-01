<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
function gotoBack(){
	location.href='<%=contextPath%>/qnaBoList.bo?${requestScope.parameters}';
	}
</script>
<div class="panel-heading">
	<h2 class="panel-title" align="left">게시물 상세 보기</h2>
</div>
<div class="row panel-body">
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
			</div>
			<span>${bean.regdate}</span>
			<h5>${bean.id}</h5>
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
							</div>
							<span>${bean.regdate}</span>
							<h5>${bean.id}</h5>
							<div id="UpdateContent${bean.boseq}">
								<p>${bean.content}</p>
							</div>
							<div id="insertReply">
								<ul>
									<li><i class="fa fa-hand-o-right"></i> Like</li>
									<li>
										<i id="comment" name="comment" class="fa fa-share-square-o"
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
	<form:form id="myform" name="myform" modelAttribute="board" method="get">
	<input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
	<input type="hidden" id="qnaseq" name="qnaseq" value="${bean.qnaseq}">
		<textarea placeholder="글내용을 작성하세요" id="content" name="content"></textarea>
		<button id="btn_register" name="btn_register" type="button"
			class="site-btn" onclick="submit1();">Submit Now</button>
		<button id="btn_previous" name="btn_register" type="button"
			class="site-btn" onclick="redirect();">뒤로가기</button>
	</form:form>
</div>
<script>
function submit1(){
	//ajax로 파일전송 폼데이터를 보내기위해
	//enctype, processData, contentType 이 세가지를 반드시 세팅해야한다.
		$.ajax({
			url : "<%=contextPath%>/qnaBoReply.bo",
		data : $('#myform').serialize(),
		type : "POST",
		datatype : 'json',
		success : function(data) {
			alert('답변 등록 완료');
			console.log(data);
			location.href = "<%=contextPath%>/qnaDetailView.bo";
			},
		eroor:function(request,status,error){
			alert('error');
		}
	});
}
function redirect() {
	$(location).attr('href', '<%=contextPath%>/qnaBoList.bo');
}
</script>
<jsp:include page="../common/footer.jsp" />