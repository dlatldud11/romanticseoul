<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String contextPath = request.getContextPath() ;
%>    
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
<div class=container>
<div class=row>
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
                <h4>Add Review</h4>
                <form action="#">
                    <input type="text" placeholder="Name">
                    <input type="text" placeholder="Email">
                    <textarea placeholder="Review"></textarea>
                    <button type="submit" class="site-btn">Submit Now</button>
                </form>
            </div>
        </div>
    </div>
  </div>
</body>
</html>