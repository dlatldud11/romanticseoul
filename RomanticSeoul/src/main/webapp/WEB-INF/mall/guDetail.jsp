<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<meta charset="UTF-8">
<!-- Listing Section Begin -->
<section class="listing-hero set-bg"
	data-setbg="img/listing/details/listing-hero.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="listing__hero__option">
					<div class="listing__hero__icon">
						<img src="img/listing/details/ld-icon.png" alt="">
					</div>
					<div class="listing__hero__text">
					<c:choose>
						<c:when test="${not empty drinkgulists}">
						<c:set var="eatgulists" value="${drinkgulists}"/>
						</c:when>
						<c:when test="${not empty lookgulists}">
						<c:set var="eatgulists" value="${drinkgulists}"/>
						</c:when>
					</c:choose>
						<c:forEach var="bean" items="${eatgulists}">
							<c:if test="${storeseq == bean.storeseq}">
								<h2>${bean.name}</h2>
								<div class="listing__hero__widget">
									<div class="listing__hero__widget__rating">
										<span class="icon_star"></span> <span class="icon_star"></span>
										<span class="icon_star"></span> <span class="icon_star"></span>
										<span class="icon_star-half_alt"></span>
									</div>
									<div>120 Review</div>
								</div>
								<p>
									<span class="icon_pin_alt"></span>${bean.address1}
								</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="listing__hero__btns">
					<a href="#" class="primary-btn share-btn"><i
						class="fa fa-mail-reply"></i> Share</a> 
						<a href="<%=contextPath%>/zziminsert.ma?storeseq=${storeseq}&mode=${mode}"
						class="primary-btn"><i class="fa fa-bookmark"></i> 찜하기</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Listing Section End -->

<!-- Listing Details Section Begin -->
<section class="listing-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="listing__details__text">
					<div class="listing__details__gallery">
						<h4>Gallery</h4>
						<div class="listing__details__gallery__pic">
							<div class="listing__details__gallery__item">
								<img class="listing__details__gallery__item__large"
									src="img/listing/details/listing-details-1.jpg" alt=""> <span><i
									class="fa fa-camera"></i> 170 Image</span>
							</div>
							<div class="listing__details__gallery__slider owl-carousel">
								<img data-imgbigurl="img/listing/details/listing-details-1.jpg"
									src="img/listing/details/thumb-1.jpg" alt=""> <img
									data-imgbigurl="img/listing/details/listing-details-1.jpg"
									src="img/listing/details/thumb-2.jpg" alt=""> <img
									data-imgbigurl="img/listing/details/listing-details-1.jpg"
									src="img/listing/details/thumb-3.jpg" alt=""> <img
									data-imgbigurl="img/listing/details/listing-details-1.jpg"
									src="img/listing/details/thumb-4.jpg" alt="">
							</div>
						</div>
					</div>
					<div class="listing__details__amenities">
						<h4>Amenities</h4>
						<div class="row">
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-1.png" alt="">
									<h6>Accept Credit Card</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-2.png" alt="">
									<h6>Free Wifi</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-3.png" alt="">
									<h6>Smoking Area</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-4.png" alt="">
									<h6>Free Parking</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-5.png" alt="">
									<h6>Family Friendly</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-6.png" alt="">
									<h6>Coffee</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-7.png" alt="">
									<h6>Massage</h6>
								</div>
							</div>
							<div class="col-lg-3 col-md-3 col-6">
								<div class="listing__details__amenities__item">
									<img src="img/listing/details/amenities/ame-8.png" alt="">
									<h6>Coupons</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="listing__details__rating">
						<h4>Rate</h4>
						<div class="listing__details__rating__overall">
							<h2>4.7</h2>
							<div class="listing__details__rating__star">
								<span class="icon_star"></span> <span class="icon_star"></span>
								<span class="icon_star"></span> <span class="icon_star"></span>
								<span class="icon_star"></span>
							</div>
							<span>(120 Rating)</span>
						</div>
						<div class="listing__details__rating__bar">
							<div class="listing__details__rating__bar__item">
								<span>4.4</span>
								<div id="bar1" class="barfiller">
									<span class="fill" data-percentage="100"></span>
								</div>
								<span class="right">Quality</span>
							</div>
							<div class="listing__details__rating__bar__item">
								<span>3.9</span>
								<div id="bar2" class="barfiller">
									<span class="fill" data-percentage="75"></span>
								</div>
								<span class="right">Price</span>
							</div>
							<div class="listing__details__rating__bar__item">
								<span>4.2</span>
								<div id="bar3" class="barfiller">
									<span class="fill" data-percentage="80"></span>
								</div>
								<span class="right">Space</span>
							</div>
							<div class="listing__details__rating__bar__item">
								<span>4.8</span>
								<div id="bar4" class="barfiller">
									<span class="fill" data-percentage="80"></span>
								</div>
								<span class="right">Service</span>
							</div>
							<div class="listing__details__rating__bar__item">
								<span>4.0</span>
								<div id="bar5" class="barfiller">
									<span class="fill" data-percentage="85"></span>
								</div>
								<span class="right">Location</span>
							</div>
						</div>
					</div>
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
								<p>${bean.name}</p>
								<div id="UpdateContent${bean.boseq}">
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
							<div class="listing__details__review">
								<c:set var="apppath" value="<%=request.getContextPath()%>" />
								<form:form id="myform" name="myform" modelAttribute="boardBoard">
									<%-- <form:form modelAttribute="boardBoard" id="myform" name="myform" method="post"
         		action="${apppath}/boInsert.bo"> --%>
									<input type="hidden" id="id" name="id"
										value="${sessionScope.loginfo.id}">
									<input type="text" id="nickname" name="nickname"
										value="${sessionScope.loginfo.nickname}" readonly
										placeholder="${sessionScope.loginfo.nickname}">
									<!-- <input type="text" placeholder="Name" id="nickname" name="nickname"> -->
									<textarea placeholder="글내용을 작성하세요" id="content" name="content"></textarea>
									<button id="btn_register" name="btn_register" type="button"
										class="site-btn" onclick="submit1();">Submit Now</button>
									<button id="btn_previous" name="btn_register" type="button"
										class="site-btn" onclick="redirect();">뒤로가기</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="listing__sidebar">
					<div class="listing__sidebar__contact">
						<div class="listing__sidebar__contact__map">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24168.833995532765!2d-74.79633710628465!3d40.78172222265886!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c384de7a5300b9%3A0x8afc61979217d49d!2sLong%20Valley%2C%20NJ%2007853%2C%20USA!5e0!3m2!1sen!2sbd!4v1586852528126!5m2!1sen!2sbd"
								height="200" style="border: 0;" allowfullscreen=""
								aria-hidden="false" tabindex="0"></iframe>
							<img src="img/listing/details/map-icon.png" alt="">
						</div>
						<div class="listing__sidebar__contact__text">
							<h4>연락처</h4>
							<ul>
								<li><span class="icon_pin_alt"></span>${bean.address1}</li>
								<li><span class="icon_phone"></span>${bean.hp}</li>
								<!-- <li><span class="icon_mail_alt"></span>
									Info.colorlib@gmail.com</li> -->
							</ul>
							<div class="listing__sidebar__contact__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"
									class="linkedin"><i class="fa fa-linkedin"></i></a> <a href="#"
									class="twitter"><i class="fa fa-twitter"></i></a> <a href="#"
									class="google"><i class="fa fa-google"></i></a>
							</div>
						</div>
					</div>
					<div class="listing__sidebar__working__hours">
						<h4>Working Hours</h4>
						<ul>
							<li>Monday <span>09:00 AM - 20:00 PM</span></li>
							<li>Tuesday <span>09:00 AM - 20:00 PM</span></li>
							<li>Wednesday <span>09:00 AM - 20:00 PM</span></li>
							<li>Thursday <span>09:00 AM - 20:00 PM</span></li>
							<li>Friday <span class="opening">Opening</span></li>
							<li>Saturday <span>09:00 AM - 20:00 PM</span></li>
							<li>Saturday <span class="closed">Closed</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Listing Details Section End -->

</body>
<script>  
var mod_check = 'N';
var reply_check = 'N';
 	
 	function openUpdate(boseq, recontent){
 		
 		if(mod_check == 'Y')
			{
				alert('수정 중입니다.');
				return;
			}
 		document.getElementById('UpdateContent'+boseq).innerHTML = "<form id='mynewform' name='mynewform'>"
 		+"<div class='form-row'>"
 		+"<textarea name='recontent' id='recontent'>"+ recontent +"</textarea></div>"
 		+"<input type='hidden' id='boseq' name='boseq' value='" + boseq +"'>"
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
		boseq : $('#boseq').val();
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
	
	var boseq = $('input#boseq').val();	
	$.ajax({
			url : "<%=contextPath%>/qnaBoReply.bo",
		data : $('#myform').serialize(),
		type : "POST",
		datatype : 'json',
		success : function(data) {
			alert('답변 등록 완료');
			console.log(data);
			location.href = "<%=contextPath%>/qnaDetailView.bo?boseq="+boseq;
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
</html>
<%@ include file="../common/footer.jsp"%>