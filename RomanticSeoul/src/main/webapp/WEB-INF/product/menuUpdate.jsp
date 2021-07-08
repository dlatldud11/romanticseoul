<%@ include file="../common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 프링 관련 설정 코드 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
button{
	margin: 30px auto 0;
}
</style>
<script>
    function writeForm(){
	location.href='<%=contextPath%>/menuDetailView.pr';
	} 
$(document).ready(function(){
	$("#btnSave").click(function(){
		var title = $("#title").val();
		var title = $("#title").val();
		if(title == ""){
			alert("제목을 입력하세요."));
			document.form.title.focus();
			return;
		}
		if(content == ""){
			alert("내용을 입력하세요.");
			document.form.title.focus();
			return;
		}
		document.form.submit();
	});
});
</script>
<link rel="stylesheet" href="css/qnainsert.css" type="text/css">
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Menu</h2>
                </div>
                <div class="card-body">
                
                <c:set var="apppath" value="<%=request.getContextPath()%>" />
                    <form:form id="form" name="form" role="form" modelattribute="Combo1" action="${apppath}/menuUpdate.pr" method="post" enctype="multipart/form-data">
                        <input type="hidden" id="menuseq" name="menuseq" value="${bean.menuseq}">
                        <input type="hidden" id="eatid" name="eatid" value="${bean.eatid}">
                        <input type="hidden" id="lookid" name="lookid" value="${bean.lookid}">
                        <input type="hidden" id="drinkid" name="drinkid" value="${bean.drinkid}">
                        <div class="form-row">
                            <div class="name">MNAME</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="mname" name="mname" value="${bean.mname}" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">QTY</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="qty" id="qty"  value="${bean.qty}">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">PRICE</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="price" id="price" value="${bean.price}">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">STARTS</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="starts" id="starts" value="${bean.starts}">
                                </div>
                            </div>
                        </div>
                       <div class="form-row">
                            <div class="name">ENDS</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="ends" id="ends" value="${bean.ends}">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                        	<div class="name">IMAGE</div>
	                        	<div class="value">
			                        <div class="form-group">
								   		<input type="file" class="form-control-file" name="file" id="file" value="${bean.file}">
									</div>
		                        <div>
	                        </div>
                        </div>
                            <button id="btnSave" class="btn btn--radius-2 btn--red" type="submit">SUBMIT</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../common/footer.jsp" />