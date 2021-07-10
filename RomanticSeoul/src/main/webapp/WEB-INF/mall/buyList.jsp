<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="./../common/common.jsp"%>
<%
	int offset = 2; //오프 셋 
	int content = 12 - 2 * offset; //12 - 2 * 오프셋
%>
<html>

<head>
<script type="text/javascript">
	function change(){
/* 	var valuekey = ('#qty').val()
	$('#price').attr('value',valuekey)
 */	alert ('onchange실행'+('#qty').val());		
	}
	
</script>
</head>
<body>
	<div class="container col-md-offset-<%=offset%> col-md-<%=content%>">
		<h3>${loginfo.nickname}님의 맞춤코스 주문하기</h3>
		<hr>
		<%-- <p>${sessionScope.loginfo.name}
			고객님<br> 고객님께서 <strong>${order.orderdate}</strong>에 구매하신 상품에 대한 상세 결제
			내역입니다.
		</p>
		<hr> --%>

		<div class="panel panel-success class">
			<div class="panel-heading">
				<!-- <h3 class="panel-title">코스 내역</h3> -->
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<c:set var="apppath" value="<%=request.getContextPath()%>" />
					<form:form id="myform" name="myform" method="post" action="${apppath}/buy.ma">
					<input type="hidden" id="first" name="first" value="${firstMenu.menuseq}">
					<input type="hidden" id="second" name="second" value="${secondMenu.menuseq}">
					<input type="hidden" id="id" name="id" value="${loginfo.id}">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">가게이름</th>
								<th class="text-center">카테고리</th>
								<th class="text-center">메뉴</th>								
								<th class="text-center">가격</th>
								<th class="text-center">예약날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr class="text-center">
									<td>${first.name}</td>
									<td>${first.category}</td>									
									<td>${firstMenu.mname}</td>									
									<td class="text-center"><fmt:formatNumber
											value="${firstMenu.price}" pattern="###,###"/> 원</td>
									<td rowspan="2"><input type="date" id="fakeredate" name="fakeregate"
									onkeyup=redate.value=this.value;>
									<input type="hidden" id="redate" mane="redate">
									</td>
									<%-- <td class="text-center"><fmt:formatNumber
											value="${shopinfo.qty}" pattern="###,###"/> 개</td>
									<td class="text-center">
										<c:set var="amount" value="${shopinfo.price * shopinfo.qty}" />
										<c:set var="totalAmount" value="${totalAmount + amount}" />
										<fmt:formatNumber value="${amount}" pattern="###,###"/> 원</td> --%>
							</tr>
							<tr class="text-center">
									<td>${second.name}</td>
									<td>${second.category}</td>									
									<td>${secondMenu.mname}</td>									
									<td class="text-center"><fmt:formatNumber
											value="${secondMenu.price}" pattern="###,###"/> 원</td>
									<%-- <td class="text-center"><fmt:formatNumber
											value="${shopinfo.qty}" pattern="###,###"/> 개</td>
									<td class="text-center">
										<fmt:formatNumber value="${amount}" pattern="###,###"/> 원</td> --%>
										<c:set var="total" value="${firstMenu.price + secondMenu.price}" />
										<c:set var="totalAmount" value="${qty * amount}" />
							</tr>
							<tr>
								<td class="thick-line"></td>
								<td class="thick-line"></td>
								<td class="thick-line text-right">
								수량
								<input type="number" id="qty" name="qty" value="1" onclick="change();">
								</td>
								<td class="thick-line text-center"><strong>합계</strong></td>
								<td class="thick-line text-right">
								<input type="text" id="price" name="price" value="${total}" readonly>
								원</td>
							</tr>
							<tr class="text-center">
							<td colspan="5">
							<button type= submit>결제</button>
							</td>
							</tr>
						</tbody>
					</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>