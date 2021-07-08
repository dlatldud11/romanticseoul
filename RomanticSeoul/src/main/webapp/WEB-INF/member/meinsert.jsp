<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String contextPath = request.getContextPath() ;
%>
<!DOCTYPE html>
<html>
<head>   
   <meta charset="utf-8">
<meta name="description" content="Directing Template">
<meta name="keywords" content="Directing, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Romantic Seoul</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700;800&display=swap"
	rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">

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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>   
<script type="text/javascript">
function checkDuplicateId(  ){
	var id = document.myform.id.value ;
	if( id.length == 0 ){
		alert('아이디를 입력해 주세요') ;
		document.myform.id.focus() ; 
		return false ;
	}
	var url='<%=contextPath%>/idcheck.me?id=' + id ; 
	window.open(url, 'mywin', 'height=150,width=300') ;
}
function checkDuplicateNickname(  ){
	var nickname = document.myform.nickname.value ;
	if( nickname.length == 0 ){
		alert('닉네임을 입력해 주세요') ;
		document.myform.nickname.focus() ; 
		return false ;
	}
	var url='<%=contextPath%>/nicknamecheck.me?nickname=' + nickname ; 
	window.open(url, 'mywin', 'height=150,width=300') ;
}

function idCheckFalse() {
document.myform.idcheck.value = false;
}

function nicknameCheckFalse() {
	document.myform.nicknamecheck.value = false;
	}

function checkForm() {
var idcheck = document.myform.idcheck.value;
var nicknamecheck = document.myform.nicknamecheck.value;
var frm = document.myform;
//alert( isCheck ) ;
if (idcheck == 'false') {
	alert('아이디 중복 체크를 해주세요.');
	return false;
}
if (nicknamecheck == 'false') {
	alert('닉네임 중복 체크를 해주세요.');
	return false;
}

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
               document.getElementById('zipcode').value = data.zonecode;
               document.getElementById("address1").value = addr;
               // 커서를 상세주소 필드로 이동한다.
               document.getElementById("address2").focus();
              }
         }
       }).open({
         left: (window.screen.width / 2) - (width / 2),
         top: (window.screen.height / 2) - (height / 2)
   });  
 }
   </script>
   <style type="text/css">
      div#piddiv,div#pwddiv,div#repwddiv,div#imagediv,div#hpdiv,div#emaildiv,div#namediv,div#birthdiv,div#genderdiv,div#addressdiv,div#zipcodediv,div#studiv,div#relationshipdiv{
         color:red;
         font-size:10pt;
         font-weight:bold;
         padding-left:5px;
      }
   </style>
    <style type="text/css">
      .err{
         font-weight: bolder;
         font-size: 9pt;
         color: red;
      }
   </style>
</head>
<body>
   <!-- <br>
   <div class="container" align="center">
      <img alt="로고" src="./../images/logo.png" width="100" height="100">
   </div>
   <br> -->
   <!-- 아이디, 비번, 이름, 성별, 휴대전화, 주소, 이미지, 닉네임, 취 -->
   <div class="card card-primary offset-sm-3 col-sm-6" id="paInsert">
      <div class="card-body">
         <div class="card-title">
            <h3 align="center" align="center">회원가입</h3>
         </div>
		<c:set var="apppath" value="<%=request.getContextPath()%>" />
         <form:form modelAttribute="member" id="myform" name="myform" method="post" enctype="multipart/form-data"
         action="${apppath}/insert.me">
         	<input type="hidden" name="idcheck" value="false">
         	<input type="hidden" name="nicknamecheck" value="false">
                <div class="form-group">
               <label for="id" class="form-control-label col-sm-0">아이디</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="id" name="id" onkeyup="idCheckFalse();">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="중복체크" onclick="checkDuplicateId();">
                  </div>
				<form:errors cssClass="err" path="id"/>
               </div>
            </div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호</label>
               <div class="col-">
                  <input type="password" class="form-control" id="password" name="password">
               </div>
				<form:errors cssClass="err" path="password"/>
            </div>
            <!-- <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호 확인</label>
               <div class="col-">
                  <input type="password" class="form-control" id="repassword" name="repassword">
               </div>
            </div> -->
            
            <div class="form-group">
               <label for="name" class="form-control-label col-sm-0">이름</label>
               <div class="col-">
                  <input type="text" class="form-control" id="name" name="name">
               </div>
				<form:errors cssClass="err" path="name"/>
            </div>
            <div class="form-group">
               <label for="nickname" class="form-control-label col-sm-0">닉네임</label>
            <div class="form-row">
				<form:errors cssClass="err" path="nickname"/>
                  <div class="col-">
                     <input type="text" class="form-control" id="nickname" name="nickname" onkeyup="nicknameCheckFalse();">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="중복체크" onclick="checkDuplicateNickname();">
                  </div>
               </div>
               </div>
            <div class="form-group">
            	<label for="gender" class="form-control-label col-sm-0">성별</label>
            	<div class="form-row">
               <label class="radio-inline"> 
				<form:radiobuttons path="gender" items="${genderlist}"
					itemLabel="mykey" itemValue="mykey"/>
					&nbsp;&nbsp;
				</label> 
				<form:errors cssClass="err" path="gender"/>
				</div>
            </div>
            <div class="form-group">
               <label for="email" class="form-control-label col-sm-0">이메일</label>
               <div class="form-row">
                  <div class="col-5">
                     <input type="text" class="form-control" id="email" name="email"> 
                  </div>
					<form:errors cssClass="err" path="email" />
               </div>
            </div>
            <div class="form-group">
               <label for="hp" class="form-control-label col-sm-0">휴대폰</label>
               <div class="col-">
                  <input type="text" class="form-control" id="hp" name="hp" placeholder="ex)01012341234">
               </div>
				<form:errors cssClass="err" path="hp" />
            </div>
            <div class="form-group">
               <label for="image" class="form-control-label col-sm-0">사진</label>
               <div class="col-">
                <input type="file" class="form-control-file border" id="file" name="file">
				<form:errors cssClass="err" path="file" />
               </div>
            </div>
            <div class="form-group">
               <label for="zipcode" class="form-control-label col-sm-0">우편번호</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" readonly>
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="우편번호검색" onclick="checkPost()">
                  </div>
               </div>
            </div>
            <div class="form-group">
               <label for="address1" class="form-control-label col-sm-0">주소</label>
               <div class="col-">
                  <input type="text" class="form-control" id="address1" name="address1" readonly>
               </div>
            </div>
            <div class="form-group">
               <label for="address2" class="form-control-label col-sm-0">상세주소</label>
               <div class="col-">
                <input type="text" class="form-control" id="address2" name="address2">
				<form:errors cssClass="err" path="address2" />
               </div>
            </div>
            <!-- 여기는 취향 설정하는 곳, 먹기,마시기,놀기,보기,걷기 -->
            <div class="form-group">
               <label for="relationship" class="form-control-label col-sm-0">취향설정</label>
               <hr>
               <div class="form-row">
               <label for="drink" class="form-control-label col-sm-0">마실것&nbsp;</label>
               <label class="radio-inline"> 
					<form:radiobuttons path="drink" items="${drinklist}"
						itemLabel="mykey" itemValue="mykey"/>
						&nbsp;&nbsp;
					</label> 
					<form:errors cssClass="err" path="drink" />
               </div>
               <div class="form-row">
               <label for="eat" class="form-control-label col-sm-0">먹을것&nbsp;</label><label class="radio-inline"> 
					<form:radiobuttons path="eat" items="${eatlist}"
						itemLabel="mykey" itemValue="mykey"/>
						&nbsp;&nbsp;
					</label> 
					<form:errors cssClass="err" path="eat" />
               </div>

               <%--<label for="play" class="form-control-label col-sm-0">놀것&nbsp;</label> <label class="radio-inline"> 
					<form:radiobuttons path="play" items="${playlist}"
						itemLabel="mykey" itemValue="mykey"/>
						&nbsp;&nbsp;
					</label> 
					<form:errors cssClass="err" path="play" />
               </div>
               <div class="form-row">
               <label for="walk" class="form-control-label col-sm-0">걷기&nbsp;</label> <label class="radio-inline"> 
					<form:radiobuttons path="walk" items="${walklist}"
						itemLabel="mykey" itemValue="mykey"/>
						&nbsp;&nbsp;
					</label> 
					<form:errors cssClass="err" path="walk" />
               </div> --%>
               <div class="form-row">
               <label for="look" class="form-control-label col-sm-0">보기&nbsp;</label> <label class="radio-inline">
					<form:radiobuttons path="look" items="${looklist}"
						itemLabel="mykey" itemValue="mykey"/>
						&nbsp;&nbsp;
					</label> 
					<form:errors cssClass="err" path="look" />
               </div>
            </div>
            <br>
                <div class="form-group form-row">
            	<div class = "col-6">
               		<input type="submit" class="form-control btn btn-primary" onclick="return checkForm();" value="회원가입">
               </div>
               <div class = "col-6">
               		<input type="reset" class="form-control btn btn-secondary" value="초기화">
               </div>
            </div>
         </form:form>
      </div>   
   </div>
   <br>
   <br>
</body>
</html>