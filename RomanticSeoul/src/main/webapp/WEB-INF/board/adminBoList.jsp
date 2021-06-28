<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 여기부터사이드바 -->
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%!String YesForm = null;
	String NoForm = null;%>
<%
String contextPath = request.getContextPath();
String mappingName = "/main";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<style>
h2 {
	text-align: center;
	padding: 20px 0;
}

ul.pagination {
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	padding: 8px;
	text-align-last: center;
	border-bottom: 1px solid #ddd;
	color: black;
}

td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function writeForm(){
		location.href='<%=contextPath%>/qnaBoInsert.bo';
	}
	function search(){
		if( $('#mode').val() == 'all' ){
			alert('검색 목록을 선택해주세요') ;
			//$('#mode').focus();
		}else{
			//alert('하하') ;
		}
		//alert( $('#mode').val() );
	}
	function searchAll(){
		//$('#mode').val('-');
		//$('#keyword').val('');
		location.href='<%=contextPath%>
	/qnaBoList.bo';
	}
</script>
</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="/main.co">MAIN</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Member</div>
						<a class="nav-link" href="/meList.me">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Member List
						</a> <a class="nav-link" href="/adminBoList.bo">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Q&A
						</a>
						<div class="sb-sidenav-menu-heading">Store</div>
						<a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Product
						</a> <a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Menu
						</a> <a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Qty
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<!--여기까지 옆에사이드바  -->
		<div id="layoutSidenav_content">
			<main>
				<section class="ftco-section">
					<div class="container">
						<h2>문의하기</h2>
						<table>
							<thead>
								<tr>
									<th>NO</th>
									<th>ID</th>
									<th>TITLE</th>
									<th>WRITEDATE</th>
									<th>CHECKS</th>
									<th>UPDATE</th>
									<th>DELETE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bean" items="${requestScope.lists}">
									<tr>
										<td>${bean.qnaseq}</td>
										<td>${bean.id}</td>
										<td><a
											href="<%=contextPath%>/qnaDetailView.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
												${bean.title} </a></td>
										<td>${bean.regdate}</td>
										<td>${bean.checks}</td>
										<td><c:if test="${sessionScope.loginfo.id == bean.id}">
												<a
													href="<%=contextPath%>/qnaBoUpdate.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
													UPDATE </a>
											</c:if></td>
										<td><c:if test="${sessionScope.loginfo.id == bean.id}">
												<a
													href="<%=contextPath%>/qnaBoDelete.bo?qnaseq=${bean.qnaseq}&${requestScope.parameters}">
													DELETE </a>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<br>
						<button class="btn btn-default btn-info" type="button"
							onclick="writeForm();">글쓰기</button>
						<br>
						<div class="row mt-5" align="center">
							<div class="col text-center">
								<div class="block-27">
									<footer>${requestScope.pagingHtml}</footer>
								</div>
							</div>
						</div>
					</div>
					<br>
				</section>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2021</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
			<script type="text/javascript">
				/* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */
				$('#mode option').each(function(index) {
					if ($(this).val() == '${requestScope.mode}') {
						$(this).attr('selected', 'selected');
					}
				});
				/* 이전에 넣었던 값 그대로 보존 */
				$('#keyword').val('${requestScope.keyword}');
			</script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
				crossorigin="anonymous"></script>
			<script src="js/scripts.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
				crossorigin="anonymous"></script>
			<script src="assets/demo/chart-area-demo.js"></script>
			<script src="assets/demo/chart-bar-demo.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
				crossorigin="anonymous"></script>
			<script src="js/datatables-simple-demo.js"></script>
</body>
</html>