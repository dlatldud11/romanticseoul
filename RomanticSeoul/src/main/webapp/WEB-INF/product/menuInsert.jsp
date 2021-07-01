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
<%--    function writeForm(){
	location.href='<%=contextPath%>/menuList.pr';
} --%>
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
                    <form:form id="form" name="form" modelAttribute="menu" role="form" action="${apppath}/menuInsert.pr" method="post" enctype="multipart/form-data">
                        <div class="form-row m-b-55">
                            <div class="name">ID</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-12">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" id="id" name="id" value="${sessionScope.loginfo.id}" disabled="disabled">
                                            <input type="hidden" name="id" id="id" value="${sessionScope.loginfo.id}" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">AREA</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="title" id="title" placeholder="어느 지역에 있어요?">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">CATEGORY</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="title" id="title" placeholder="어느 캐터고리 이신가요?">
                                </div>
                            </div>
                        </div>
                       <div class="form-row">
                            <div class="name">category</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="title" id="title" placeholder="세분화 해주세요^^">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">STORE NAME</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="title" id="title" placeholder="가게이름은 어떻게 돼세요?">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                        	<div class="name">IMAGE</div>
	                        	<div class="value">
			                        <div class="form-group">
								   		<input type="file" class="form-control-file" name="file" id="file">
									</div>
		                        <div>
	                        </div>
                        </div>
                            <button id="btnSave" class="btn btn--radius-2 btn--red" type="submit" onclick="writeForm();">SUBMIT</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../common/footer.jsp" />