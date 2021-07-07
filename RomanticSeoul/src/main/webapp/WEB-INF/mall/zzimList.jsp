<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- whologin 변수는 로그인 상태를 저장하고 있는 변수입니다. -->
<c:set var="whologin" value="0" />
<c:if test="${empty sessionScope.loginfo}">
	<!-- 로그인 하지 않은 경우 -->
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.id == 'admin'}">
		<!-- 관리자로 로그인한 경우 -->
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${sessionScope.loginfo.id != 'admin'}">
		<!-- 일반 사용자로 로그인한 경우 -->
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>

<%!
	String YesForm = null ;
	String NoForm = null ;
%>
<%
String contextPath = request.getContextPath();
String mappingName = "/main";
%>
<!DOCTYPE html>
<html lang="zxx">

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

<body class="ov-hid">
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header header--normal">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/footer-logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9 col-md-9">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="./index.html">Home</a></li>
                                <li class="active"><a href="./listing.html">Listing</a></li>
                                <li><a href="#">Categories</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="./about.html">About</a></li>
                                        <li><a href="./listing-details.html">Listing Details</a></li>
                                        <li><a href="./blog-details.html">Blog Details</a></li>
                                        <li><a href="./contact.html">Contact</a></li>
                                    </ul>
                                </li>
                                <li><a href="./blog.html">Blog</a></li>
                                <li><a href="#">Shop</a></li>
                            </ul>
                        </nav>
                        <div class="header__menu__right">
                            <a href="#" class="primary-btn"><i class="fa fa-plus"></i>Add Listing</a>
                            <a href="#" class="login-btn"><i class="fa fa-user"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Filter Begin -->
    <div class="filter nice-scroll">
        <div class="filter__title">
            <h5><i class="fa fa-filter"></i> Filter</h5>
        </div>
        <div class="filter__search">
            <input type="text">
        </div>
        <div class="filter__select">
            <select>
                <option value="">All Categories</option>
            </select>
        </div>
        <div class="filter__location">
            <input type="text" placeholder="Location">
            <i class="fa fa-map-marker"></i>
        </div>
        <div class="filter__radius">
            <p>Radius:</p>
            <div class="price-range-wrap">
                <div
                    class="price-range-radius ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content">
                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                </div>
                <div class="range-slider">
                    <div class="price-input">
                        <input type="text" id="radius">
                    </div>
                </div>
            </div>
        </div>
        <div class="filter__price">
            <p>Price:</p>
            <div class="price-range-wrap">
                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content">
                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                </div>
                <div class="range-slider">
                    <div class="price-input">
                        <input type="text" id="minamount">
                        <input type="text" id="maxamount" value="$80">
                    </div>
                </div>
            </div>
        </div>
        <div class="filter__tags">
            <h6>Tag</h6>
            <label for="coupon">
                Coupons
                <input type="checkbox" id="coupon">
                <span class="checkmark"></span>
            </label>
            <label for="sa">
                Smoking Allowed
                <input type="checkbox" id="sa">
                <span class="checkmark"></span>
            </label>
            <label for="camping">
                Camping
                <input type="checkbox" id="camping">
                <span class="checkmark"></span>
            </label>
            <label for="hot-spots">
                Hot Spots
                <input type="checkbox" id="hot-spots">
                <span class="checkmark"></span>
            </label>
            <label for="internet">
                Internet
                <input type="checkbox" id="internet">
                <span class="checkmark"></span>
            </label>
            <label for="tr">
                Top Rated
                <input type="checkbox" id="tr">
                <span class="checkmark"></span>
            </label>
            <label for="hd">
                Hot Deal
                <input type="checkbox" id="hd">
                <span class="checkmark"></span>
            </label>
        </div>
        <div class="filter__btns">
            <button type="submit">Filter Results</button>
            <button type="submit" class="filter__reset">Reset All</button>
        </div>
    </div>
    <!-- Filter End -->

    <!-- Listing Section Begin -->
    <section class="listing nice-scroll">
        <div class="listing__text__top">
            <div class="listing__text__top__left">
                <h5>가게 찜목록</h5>
                <span>18 Results Found</span>
            </div>
            <div class="listing__text__top__right">Nearby <i class="fa fa-sort-amount-asc"></i></div>
        </div>
        <div class="listing__list">
            <!-- 찜목록 가게 리스트 시작 -->
            <c:forEach var="zzim" items="${myplanlists}">
            <c:forEach var="store" items="${storelists}">
            <c:if test="${zzim.eatid eq store.storeseq || zzim.drinkid eq store.storeseq || zzim.lookid eq store.storeseq }">
            <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-1.jpg">
                    <img src="img/listing/list_icon-1.png" alt="">
                    <div class="listing__item__pic__tag">
                    	 <c:choose>
                            <c:when test="${not empty zzim.eatid}">
                            	먹을거리
                            </c:when>
                            <c:when test="${not empty zzim.drinkid}">
                            	마실거리
                            </c:when>
                            <c:otherwise>
								볼거리
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>${store.name}</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <div class="filter__select">
								<select id="menu" name="menu" class="form-control">
									<option value="all" selected="selected">-- Menu
									<c:forEach var="menu" items="${menulists}">
									<c:if test="${store.storeseq eq menu.eatid || store.storeseq eq menu.drinkid || store.storeseq eq menu.lookid }">
									<option value="${menu.menuseq}">${menu.mname}&nbsp;&nbsp;&nbsp;${menu.price}
									</c:if>
									</c:forEach>
								</select>
					        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span>
                            <c:choose>
                            <c:when test="${not empty store.address2 }">
                            	${store.address2}
                            </c:when>
                            <c:otherwise>
                            	${store.address1}
                            </c:otherwise>
                            </c:choose>
                            </li>
                            <li><span class="icon_phone"></span> ${store.hp}</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-1.png" alt="">
                            <span>${store.category}</span>
                        </div>
                        <div class="listing__item__text__info__right">${store.remark}</div>
                    </div>
                </div>
            </div>
            </c:if>
            </c:forEach>
            </c:forEach>
            <!-- 찜목록 가게 리스트 끝 -->
            <!-- <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-2.jpg">
                    <img src="img/listing/list_icon-2.png" alt="">
                    <div class="listing__item__pic__tag top_rate">Top Rate</div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>Shrimp floured and fried</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <h6>$40 - $70</h6>
                        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span> 1012 Vesper Dr. Columbus, Georgia(GA), United States
                            </li>
                            <li><span class="icon_phone"></span> (+12) 345-678-910</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-2.png" alt="">
                            <span>Food & Drink</span>
                        </div>
                        <div class="listing__item__text__info__right closed">Closed</div>
                    </div>
                </div>
            </div>
            <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-4.jpg">
                    <img src="img/listing/list_icon-4.png" alt="">
                    <div class="listing__item__pic__tag">Popular</div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>Crab fried with tamarind</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <h6>$40 - $70</h6>
                        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span> 14320 Keenes Mill Rd. Cottondale, Alabama(AL), United
                                States</li>
                            <li><span class="icon_phone"></span> (+12) 345-678-910</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-3.png" alt="">
                            <span>Hotel</span>
                        </div>
                        <div class="listing__item__text__info__right closed">Closed</div>
                    </div>
                </div>
            </div>
            <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-3.jpg">
                    <img src="img/listing/list_icon-3.png" alt="">
                    <div class="listing__item__pic__tag">Popular</div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>Sweet and sour pork ribs</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <h6>$40 - $70</h6>
                        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span> 251 Wiley St. Forks, Washington(WA), United States
                            </li>
                            <li><span class="icon_phone"></span> (+12) 345-678-910</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-1.png" alt="">
                            <span>Restaurant</span>
                        </div>
                        <div class="listing__item__text__info__right">Open Now</div>
                    </div>
                </div>
            </div>
            <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-5.jpg">
                    <img src="img/listing/list_icon-5.png" alt="">
                    <div class="listing__item__pic__tag hot_deal">Hot Deal</div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>Tortoise grilled on salt</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <h6>$40 - $70</h6>
                        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span> 236 Littleton St. New Philadelphia, Ohio, United
                                States</li>
                            <li><span class="icon_phone"></span> (+12) 345-678-910</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-4.png" alt="">
                            <span>Shopping</span>
                        </div>
                        <div class="listing__item__text__info__right">Open Now</div>
                    </div>
                </div>
            </div>
            <div class="listing__item">
                <div class="listing__item__pic set-bg" data-setbg="img/listing/list-6.jpg">
                    <img src="img/listing/list_icon-6.png" alt="">
                    <div class="listing__item__pic__tag">Popular</div>
                    <div class="listing__item__pic__btns">
                        <a href="#"><span class="icon_zoom-in_alt"></span></a>
                        <a href="#"><span class="icon_heart_alt"></span></a>
                    </div>
                </div>
                <div class="listing__item__text">
                    <div class="listing__item__text__inside">
                        <h5>Fish cooked with fishsauce</h5>
                        <div class="listing__item__text__rating">
                            <div class="listing__item__rating__star">
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star"></span>
                                <span class="icon_star-half_alt"></span>
                            </div>
                            <h6>$40 - $70</h6>
                        </div>
                        <ul>
                            <li><span class="icon_pin_alt"></span> 2604 E Drachman St. Tucson, Arizona, United States
                            </li>
                            <li><span class="icon_phone"></span> (+12) 345-678-910</li>
                        </ul>
                    </div>
                    <div class="listing__item__text__info">
                        <div class="listing__item__text__info__left">
                            <img src="img/listing/list_small_icon-3.png" alt="">
                            <span>Hotel</span>
                        </div>
                        <div class="listing__item__text__info__right">Open Now</div>
                    </div>
                </div>
            </div>
        </div> -->
    </section>
    <!-- Listing Section End -->

    <!-- Map Begin -->
    <div class="listing__map">
        <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d423283.43556031643!2d-118.69192431097179!3d34.020730495817475!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2c75ddc27da13%3A0xe22fdf6f254608f4!2sLos%20Angeles%2C%20CA%2C%20USA!5e0!3m2!1sen!2sbd!4v1586670019340!5m2!1sen!2sbd" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
    </div>
    <!-- Map End -->

    <!-- Js Plugins -->
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
</body>

</html>