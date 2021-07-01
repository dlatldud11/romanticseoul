<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<%@ include file="map.jsp"%>
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
												<h6>$40 - $70</h6>
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
				<div class="section-title">
					<h2>Trusted By Over 5000+ User</h2>
					<p>What people say about us</p>
				</div>
				<div class="testimonial__slider owl-carousel">
					<div class="testimonial__item" data-hash="review-1">
						<p>" We worked with Consultant. Our representative was very
							knowledgeable and helpful. Consultant made a number of
							suggestions to help improve our systems. Consultant explained how
							things work and why it would help."</p>
						<div class="testimonial__item__author">
							<a href="#review-3"><img src="img/testimonial/author-3.png"
								alt=""></a> <a href="#review-1" class="active"><img
								src="img/testimonial/author-1.png" alt=""></a> <a
								href="#review-2"><img src="img/testimonial/author-2.png"
								alt=""></a>
						</div>
						<div class="testimonial__item__author__text">
							<h5>John Smith -</h5>
							<div class="testimonial__item__author__rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<span>CEO Colorlib</span>
					</div>
					<div class="testimonial__item" data-hash="review-2">
						<p>" We worked with Consultant. Our representative was very
							knowledgeable and helpful. Consultant made a number of
							suggestions to help improve our systems. Consultant explained how
							things work and why it would help."</p>
						<div class="testimonial__item__author">
							<a href="#review-1"><img src="img/testimonial/author-1.png"
								alt=""></a> <a href="#review-2" class="active"><img
								src="img/testimonial/author-2.png" alt=""></a> <a
								href="#review-3"><img src="img/testimonial/author-3.png"
								alt=""></a>
						</div>
						<div class="testimonial__item__author__text">
							<h5>John Smith -</h5>
							<div class="testimonial__item__author__rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<span>CEO Colorlib</span>
					</div>
					<div class="testimonial__item" data-hash="review-3">
						<p>" We worked with Consultant. Our representative was very
							knowledgeable and helpful. Consultant made a number of
							suggestions to help improve our systems. Consultant explained how
							things work and why it would help."</p>
						<div class="testimonial__item__author">
							<a href="#review-2"><img src="img/testimonial/author-2.png"
								alt=""></a> <a href="#review-3" class="active"><img
								src="img/testimonial/author-3.png" alt=""></a> <a
								href="#review-1"><img src="img/testimonial/author-1.png"
								alt=""></a>
						</div>
						<div class="testimonial__item__author__text">
							<h5>John Smith -</h5>
							<div class="testimonial__item__author__rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i>
							</div>
						</div>
						<span>CEO Colorlib</span>
					</div>
				</div>
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
<!-- Newslatter Section End -->
<%@ include file="footer.jsp"%>