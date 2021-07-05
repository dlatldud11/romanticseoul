<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<%@ include file="map.jsp"%>
<!-- 다음 주소검색 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>   
<!-- 지도를 표시할 div 입니다 -->

<!-- Most Search Section Begin -->
<meta charset="UTF-8">
<section class="most-search spad">
	<div class="container">
		<div class="row">
			<div class="section-title" style="font-family: 'Noto Sans KR', sans-serif;">
				<div class="guName"
					style="margin: auto; padding-bottom: 20px;">
					<h3>
						<span id="guName" style="font-family: 'Noto Sans KR', sans-serif;"></span>
					</h3>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="tab-content">
					<div class="tab-pane active" id="tabs-1" role="tabpanel">
						<div class="row">
							<c:forEach var="bean" items="${eatgulists}">
							<div class="col-lg-4 col-md-6">
								<div class="listing__item">
									<div class="listing__item__pic set-bg"
										data-setbg="img/listing/list-1.jpg">
										<img src="img/listing/list_icon-1.png" alt="">
										<div class="listing__item__pic__tag">Popular</div>
										<div class="listing__item__pic__btns">
											<a href="#"><span class="icon_zoom-in_alt"></span></a> <a
												href="#"><span class="icon_heart_alt"></span></a>
										</div>
									</div>
									<div class="listing__item__text">
										<div class="listing__item__text__inside">
											<h5>${bean.name}</h5>
											<div class="listing__item__text__rating">
												<div class="listing__item__rating__star">
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star-half_alt"></span>
												</div>
												<h6>${bean.storeseq}</h6>
											</div>
											<ul>
												<li><span class="icon_pin_alt"></span> 
												${bean.address2}</li>
												<li><span class="icon_phone"></span> ${bean.hp}</li>
											</ul>
										</div>
										<div class="listing__item__text__info">
											<div class="listing__item__text__info__left">
												<img src="img/listing/list_small_icon-1.png" alt=""> <span>${bean.category}</span>
											</div>
											<div class="listing__item__text__info__right">${bean.remark}</div>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>
							<c:forEach var="bean" items="${drinkgulists}">
							<div class="col-lg-4 col-md-6">
								<div class="listing__item">
									<div class="listing__item__pic set-bg"
										data-setbg="img/listing/list-2.jpg">
										<img src="img/listing/list_icon-2.png" alt="">
										<div class="listing__item__pic__tag top_rate">Top Rate</div>
										<div class="listing__item__pic__btns">
											<a href="#"><span class="icon_zoom-in_alt"></span></a> <a
												href="#"><span class="icon_heart_alt"></span></a>
										</div>
									</div>
									<div class="listing__item__text">
										<div class="listing__item__text__inside">
											<h5>${bean.name}</h5>
											<div class="listing__item__text__rating">
												<div class="listing__item__rating__star">
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star-half_alt"></span>
												</div>
												<h6>$40 - $70</h6>
											</div>
											<ul>
												<li><span class="icon_pin_alt"></span>
												${bean.address2}
												</li>
												<li><span class="icon_phone"></span>${bean.hp}</li>
											</ul>
										</div>
										<div class="listing__item__text__info">
											<div class="listing__item__text__info__left">
												<img src="img/listing/list_small_icon-2.png" alt=""> 
												<span>${bean.category}</span>
											</div>
											<div class="listing__item__text__info__right closed">${bean.remark}</div>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>	
							
							<c:forEach var="bean" items="${lookgulists}">
 							<div class="col-lg-4 col-md-6">
								<div class="listing__item">
									<div class="listing__item__pic set-bg"
										data-setbg="img/listing/list-3.jpg">
										<img src="img/listing/list_icon-3.png" alt="">
										<div class="listing__item__pic__tag">Popular</div>
										<div class="listing__item__pic__btns">
											<a href="#"><span class="icon_zoom-in_alt"></span></a> <a
												href="#"><span class="icon_heart_alt"></span></a>
										</div>
									</div>
									<div class="listing__item__text">
										<div class="listing__item__text__inside">
											<h5>${bean.name}</h5>
											<div class="listing__item__text__rating">
												<div class="listing__item__rating__star">
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star"></span> <span class="icon_star"></span>
													<span class="icon_star-half_alt"></span>
												</div>
												<h6>$40 - $70</h6>
											</div>
											<ul>
												<li><span class="icon_pin_alt"></span>
												${bean.address2}
												</li>
												<li><span class="icon_phone"></span>없으니까 삭제 고려</li>
											</ul>
										</div>
										<div class="listing__item__text__info">
											<div class="listing__item__text__info__left">
												<img src="img/listing/list_small_icon-1.png" alt=""> 
												<span>${bean.category}</span>
											</div>
											<div class="listing__item__text__info__right">내용없으니 삭제 고려</div>
										</div>
									</div>
								</div>
							</div> <!-- 가게 리스트 -->
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Most Search Section End -->
<!-- Hero Section Begin -->
<section class="hero set-bg" data-setbg="img/hero/hero-bg.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="hero__text">
					<div class="section-title">
						<h2>Discover The Best Services Near You</h2>
						<p>1.118.940.376 The best service package is waiting for you</p>
					</div>
					<div class="hero__search__form">
						<form action="#">
							<input type="text" placeholder="Search...">
							<div class="select__option">
								<select>
									<option value="">Choose Categories</option>
								</select>
							</div>
							<div class="select__option">
								<select>
									<option value="">Choose Location</option>
								</select>
							</div>
							<button type="submit">Explore Now</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->
<!-- Categories Section Begin -->
<section class="categories spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Most Popular Categories</h2>
					<p>Travelocity empowers travelers who are giving back on their
						trips in ways big and small</p>
				</div>
				<div class="categories__item__list">
					<div class="categories__item">
						<img src="img/categories/cat-1.png" alt="">
						<h5>Food & Drink</h5>
						<span>78 Listings</span>
					</div>
					<div class="categories__item">
						<img src="img/categories/cat-2.png" alt="">
						<h5>Restaurent</h5>
						<span>32 Listings</span>
					</div>
					<div class="categories__item">
						<img src="img/categories/cat-3.png" alt="">
						<h5>Hotels</h5>
						<span>16 Listings</span>
					</div>
					<div class="categories__item">
						<img src="img/categories/cat-4.png" alt="">
						<h5>Beauty & Spa</h5>
						<span>55 Listings</span>
					</div>
					<div class="categories__item">
						<img src="img/categories/cat-5.png" alt="">
						<h5>Shopping</h5>
						<span>23 Listings</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section End -->

<!-- Testimonial Section Begin -->
<section class="testimonial spad set-bg"
	data-setbg="img/testimonial/testimonial-bg.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form action="<%=contextPath%>/meCoList.pr" id="mecoform" name="mecoform" method="post">
				<div class="section-title">
					<h2>취향에 맞는 코스를 추천해드립니다!</h2>
					<p>현재 위치를 입력해 주세요</p>
				</div>
				<div class="hero__search__form">
							<input type="text" placeholder="현재 위치를 입력해주세요." id="address" name="address" readonly>
							<button type="button" onclick="checkPost()">주소 검색하기</button>
					</div>
					<div class="row">
							<div class="select__option">
								<select id="first" name="first">
									<option value="">첫번째 코스 선택</option>
									<option value="eat/${sessionScope.loginfo.eat}">먹거리(${sessionScope.loginfo.eat})</option>
									<option value="drink/${sessionScope.loginfo.drink}">마실거리(${sessionScope.loginfo.drink})</option>
									<option value="look/${sessionScope.loginfo.look}">볼거리(${sessionScope.loginfo.look})</option>
								</select>
							</div>
							<div class="select__option">
								<select id="second" name="second">
									<option value="">두번째 코스 선택</option>
									<option value="eat/${sessionScope.loginfo.eat}">먹거리(${sessionScope.loginfo.eat})</option>
									<option value="drink/${sessionScope.loginfo.drink}">마실거리(${sessionScope.loginfo.drink})</option>
									<option value="look/${sessionScope.loginfo.look}">볼거리(${sessionScope.loginfo.look})</option>
								</select>
							</div>
							<div class="select__option">
								<select id="third" name="third">
									<option value="">세번째 코스 선택</option>
									<option value="eat/${sessionScope.loginfo.eat}">먹거리(${sessionScope.loginfo.eat})</option>
									<option value="drink/${sessionScope.loginfo.drink}">마실거리(${sessionScope.loginfo.drink})</option>
									<option value="look/${sessionScope.loginfo.look}">볼거리(${sessionScope.loginfo.look})</option>
								</select>
							</div>
					</div>
					<div class="testimonial__item" data-hash="review-1">
						<button type="button">취향 설정 변경하기</button>
						<button type="submit">코스 추천받기</button>
					</div>
			</form>
			</div>
		</div>
	</div>
</section>
<!-- Testimonial Section End -->
<!-- Feature Location Section Begin -->
<section class="feature-location spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Top Featured Locations</h2>
					<p>Explore restaurants, bars, and cafés by locality</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-3 col-md-3">
						<a href="#" class="feature__location__item set-bg"
							data-setbg="img/feature-location/fl-2.jpg">
							<div class="feature__location__item__text">
								<h5>Chicago</h5>
							</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3">
						<a href="#" class="feature__location__item set-bg"
							data-setbg="img/feature-location/fl-3.jpg">
							<div class="feature__location__item__text">
								<h5>San Antonio</h5>
							</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3">
						<a href="#" class="feature__location__item set-bg"
							data-setbg="img/feature-location/fl-2.jpg">
							<div class="feature__location__item__text">
								<h5>Chicago</h5>
							</div>
						</a>
					</div>
					<div class="col-lg-3 col-md-3">
						<a href="#" class="feature__location__item set-bg"
							data-setbg="img/feature-location/fl-3.jpg">
							<div class="feature__location__item__text">
								<h5>San Antonio</h5>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
function checkPost1(){
	alert('checkPost1');
}
/* 다음주소검색 api */
    function checkPost() {
      var width = 500; //팝업의 너비
      var height = 500; //팝업의 높이
      
       new daum.Postcode({
         width : width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
           height : height,
      
           oncomplete: function(data) {
              var addr = ''; // 주소 변수
              var extraAddr = ''; // 참고항목 변수

              //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
              if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   addr = data.roadAddress;
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   addr = data.jibunAddress;
               }

               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
               if(data.userSelectedType === 'R'){
                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있고, 공동주택일 경우 추가한다.
                   if(data.buildingName !== '' && data.apartment === 'Y'){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
           
               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById("address").value = addr;
               // 커서를 상세주소 필드로 이동한다.
              }
         }
       }).open({
         left: (window.screen.width / 2) - (width / 2),
         top: (window.screen.height / 2) - (height / 2)
   });  
 }
</script>
<!-- Newslatter Section End -->
<%@ include file="footer.jsp"%>