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
	
$(document).ready(function(){
	/* $('#monthto').val(monthArray[1]).prop("selected", true); //값이 1인 option 선택 */
	   // process.. 
	});
	function check1(){
		/*var month = monthArray[1]; */
		alert($('#monthto').val());
		var month = $('#monthto').val();
		/* var monthArray = '<c:out value="${month}"/>';
		monthArray = monthArray.split('/'); */	
		$(location).attr("href","${contextPath}/meBuy.me?id=${loginfo.id}&month="+month);
		/*$.ajax({
	                 type: "get",
	                 url : '${contextPath}/meBuy.me',
	                 data: {'id': '${sessionScope.loginfo.id}','month' :month },
	                 dataType : 'json',
	                 success: function(data){
	                	 alert('성공');
	                      console.log(JSON.stringify(data)) 
	                      console.log(data.list)
	                       $.each(data.list, function(index, items){
	                            console.log(items.food_name)
 	                               var shtml = '';
	                               shtml += '<tr>';
	                               shtml += '<td><input type="checkbox" name="starcheck" onclick="event.cancelBubble=true;"></td>';
	                                shtml += '<td style="display:none;">'+items.mf_seq+'</td>';
	                                shtml += '<td>'+items.food_name+'</td>';
	                                shtml += '<td>'+items.serving_wt+'</td>';
	                                shtml += '<td>'+items.calorie +'</td>';
	                                shtml += '<td>'+items.carbohydrate+'</td>';
	                                shtml += '<td>'+items.protein+'</td>';
	                                shtml += '<td>'+items.fat+'</td>';
	                                shtml += '<td>'+items.na+'</td>';
	                                shtml += '</tr>'
	                                
	                                $("#starTable").append(shtml);

	                         }) 
	                      },error: function(err){
	                      console.log("error발생"+err);
	                    } 
	                 })*/

	}
	</script>
</head>
<body>
	<div class="container col-md-offset-<%=offset%> col-md-<%=content%>">
		<h1>${sessionScope.loginfo.name}님의 주문 상세 내역</h1>
		<hr>
		<p>${sessionScope.loginfo.name}
			고객님<br> 고객님께서 <strong id="month" name="month">
			<fmt:parseDate value="${month}" var="month1" pattern="yyyy/MM"/>
			<fmt:formatDate value="${month1}" pattern="MM월"/></strong>에 구매하신 상품에 대한 상세 결제
			내역입니다.
		</p>
		<hr>

		<div class="panel panel-success class">
			<div class="panel-heading">
				<h3 class="panel-title">
				<select id="monthto" name="monthto" onchange="check1();">
					<option value="">
					<fmt:parseDate value="${month}" var="month1" pattern="yyyy/MM"/>
					<fmt:formatDate value="${month1}" pattern="MM월"/>
					</option>
					<option value="01">1월</option>
					<option value="02">2월</option>
					<option value="03">3월</option>
					<option value="04">4월</option>
					<option value="05">5월</option>
					<option value="06">6월</option>
					<option value="07">7월</option>
					<option value="08">8월</option>
					<option value="09">9월</option>
					<option value="10">10월</option>
					<option value="11">11월</option>
					<option value="12">12월</option>
				</select>
				주문 내역</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">코스</th>
								<th class="text-center">카테고리</th>								
								<th class="text-center">가게이름</th>								
								<th class="text-center">메뉴</th>
								<th class="text-center">가격</th>
								<th class="text-center">수량</th>
								<th class="text-center">예약날짜</th>
								<th class="text-center">결제날짜</th>
								<th class="text-center">합계</th>
							</tr>
						</thead>
							<c:set var="totalAmount" value="0" />
							<c:set var="totalCount" value="0" />
							<c:forEach items="${lists}" var="bean">
							<c:if test="${fn:contains(bean.regdate, month)}">
						<tbody>
								<tr>
									<td>1</td>
									<td>
										${firststore.category}										
									</td>
									<td>
										${firststore.name}
									</td>
									<td>${bean.firstmname}</td>
									<td class="text-center"><fmt:formatNumber
											value="${bean.firstprice}" pattern="###,###"/> 원</td>
									<td rowspan="2" class="align-middle"><fmt:formatNumber
											value="${bean.qty}" pattern="###,###"/> 개</td>
										<%-- <c:set var="firstamount" value="${bean.firstprice + bean.secondprice}" />
										<c:set var="totalAmount" value="${bean.qty * amount}" /> --%>
										<c:set var="totalAmount" value="${totalAmount + bean.price}" />
										<c:set var="totalCount" value="${totalCount + 1}" />
									<td rowspan="2" class="align-middle">
									<fmt:parseDate value="${bean.redate}" var="redate" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${redate}" pattern="yyyy년MM월dd일"/>
									</td>
									<td rowspan="2" class="align-middle">
									<fmt:parseDate value="${bean.regdate}" var="regdate" pattern="yyyy/MM/dd/hh:mm"/>
									<fmt:formatDate value="${regdate}" pattern="yyyy년MM월dd일 hh시mm분"/>
									</td>
									<td rowspan="2" class="align-middle">
									<fmt:formatNumber
											value="${bean.price}" pattern="###,###"/> 원
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>
										${secondstore.category}										
									</td>
									<td>
										${secondstore.name}
									</td>
									<td>${bean.secondmname}</td>
									<td class="text-center"><fmt:formatNumber
											value="${bean.secondprice}" pattern="###,###"/> 원</td>
								</tr>
							<%-- <tr>
								<td colspan="7" class="thick-line text-right"><strong>합계</strong>
								&nbsp;&nbsp;&nbsp;
								<fmt:formatNumber
										value="${bean.price}" pattern="###,###" /> 원</td>
							</tr> --%>
							<tr>
							<td colspan="9"></td>
							</tr>
						</tbody>
						</c:if>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<div class="panel panel-success class">
			<div class="panel-heading">
				<h3 class="panel-title">결제 정보</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="text-center gr"><strong>주문 총액</strong></td>
								<td><fmt:formatNumber value="${totalAmount}" pattern="###,###"/> 원</td>
								<td class="text-center gr"><strong>주문 건수</strong></td>
								<td>${totalCount}건</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>