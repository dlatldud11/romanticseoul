<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
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
<script type="text/javascript">
   
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
//    function add_input(){
//       var writeForm = document.writeForm.getElementById("box");
//       // create element(input)
//       var input1 = document.createElement('input');
//       var input2 = document.createElement('input');
//       // set attribute(input)
//       input1.setAttribute("type", "number");
//       input1.setAttribute("name", "childid");
//       input2.setAttribute("type", "number");
//       input2.setAttribute("name", "childid2");
//       
//       writeForm.appendChild(input1);
//       writeForm.appendChild(input2);
//       
//       writeForm.submit;
//    }    


   function add_input(){
		document.getElementById('second').value='second';
		document.getElementById('btnfirst').onclick = null;
		document.getElementById('searchfirst').onclick = null;
	
     	 document.getElementById('childsecond').innerHTML ="<div class='form-row' id='deleteid'><div class='col-'>"
      	+"<input type='text' name='childid' class='form-control' readonly></div><div class='col-'>"
         +"<input type='button' class='form-control btn btn-primary' id=searchsecond value='원생 찾기' onclick='stSearch();'>"
         +"</div><div class='col-'>"
         +"<input type='button' class='btn btn-secondary' onclick='add_input2();' id='btnsecondadd' value='추가'> </div> <div class='col-'>"
         +"<input type='button' class='btn btn-danger' onclick='delete_input();' id='btnsecond' value='삭제'> </div> </div>";
   }
   
   function add_input2(){
	  	 document.getElementById('third').value='third';
	 	 document.getElementById('btnsecond').onclick = null;
	 	 document.getElementById('btnsecondadd').onclick = null;
	 	 document.getElementById('searchsecond').onclick = null;
	 	 
     	 document.getElementById('childthird').innerHTML ="<div class='form-row' id='deleteid2'><div class='col-'>"
         +"<input type='text' name='childid2' class='form-control' readonly></div><div class='col-'>"
         +"<input type='button' class='form-control btn btn-primary' value='원생 찾기' onclick='stSearch();'>"
         +"</div><div class='col-'>"
         +"<input type='button' class='btn btn-danger' onclick='delete_input2();' value='삭제'></div> </div>";
   }
   
   function delete_input(){
	   	document.getElementById('second').value="";
      	document.getElementById('deleteid').outerHTML = "";
      	document.getElementById('btnfirst').onclick = add_input;
      	document.getElementById('searchfirst').onclick = stSearch;
   }
   
   function delete_input2(){
	   	document.getElementById('third').value="";
      	document.getElementById('deleteid2').outerHTML = "";
      	document.getElementById('btnsecond').onclick = delete_input;
      	document.getElementById('btnsecondadd').onclick = add_input2;
      	document.getElementById('searchsecond').onclick = stSearch;
   }
   
   function stSearch(){
      var url = '<%=NoForm%>paStSearch';
      window.open(url, 'stsearch', 'height=200, width=330, menubar=no, location=no, left=400, top=200');
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
            <h1 align="center" align="center">회원가입</h1>
         </div>
         <form action="<%=YesForm %>" name="writeForm" method="post" enctype="multipart/form-data">
         	<input type="hidden" name="idcheck" value="false">
            <input type="hidden" name="command" value="paInsert">
                <div class="form-group">
               <label for="pid" class="form-control-label col-sm-0">아이디</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="pid" name="pid" onkeyup="idcheckFalse();">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="중복체크" onclick="checkPid();">
                  </div>
               </div>
            </div>
            <div class="form-group" id="piddiv"></div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호</label>
               <div class="col-">
                  <input type="password" class="form-control" id="password" name="password">
               </div>
            <div class="form-group" id="pwddiv"></div>
            </div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호 확인</label>
               <div class="col-">
                  <input type="password" class="form-control" id="repassword" name="repassword">
               </div>
            </div>
            <div class="form-group" id="repwddiv"></div>
            
            <div class="form-group">
               <label for="name" class="form-control-label col-sm-0">이름</label>
               <div class="col-">
                  <input type="text" class="form-control" id="name" name="name">
               </div>
            </div>
             <div class="form-group" id="namediv"></div>
            <div class="form-group">
               <label for="birth" class="form-control-label col-sm-0">닉네임</label>
            <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="pid" name="pid" onkeyup="idcheckFalse();">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="중복체크" onclick="checkPid();">
                  </div>
               </div>
               </div>
            <div class="form-group">
               <label for="gender" class="form-control-label col-sm-0">성별</label>
                  <div class="form-row">
                     <div class="col-1">
                        <input type="radio" class="form-control" id="gender" name="gender" value="남">
                     </div>
                     <label for="gender" class="form-control-label col-sm-0">&nbsp;남&nbsp;</label>
                     <div class="col-1">
                        <input type="radio" class="form-control" id="gender" name="gender" value="여">
                     </div>
                     <label for="gender" class="form-control-label col-sm-0">&nbsp;여&nbsp;</label>
               	</div>
            </div>
             <div class="form-group" id="genderdiv"></div>
            <div class="form-group">
               <label for="email" class="form-control-label col-sm-0">이메일</label>
               <div class="form-row">
                  <div class="col-5">
                     <input type="text" class="form-control" id="email1" name="email1"> 
                  </div>
                  <label for="email" class="form-control-label col-sm-0">&nbsp;@&nbsp;</label>
                  <div class="col-5">
                     <select class="form-control" name="email2" id="email2">
                        <option value="-">---선택하세요
                        <option value="naver.com">naver.com
                        <option value="gmail.com">gmail.com
                        <option value="daum.net">daum.net         
                     </select>
                  </div>
               </div>
            </div>
             <div class="form-group" id="emaildiv"></div>
            <div class="form-group">
               <label for="hp" class="form-control-label col-sm-0">휴대폰</label>
               <div class="col-">
                  <input type="number" class="form-control" id="hp" name="hp" placeholder="ex)01012341234">
               </div>
            </div>
             <div class="form-group" id="hpdiv"></div>
            <div class="form-group">
               <label for="image" class="form-control-label col-sm-0">사진</label>
               <div class="col-">
                  <input type="file" class="form-control-file border" id="image" name="image">
               </div>
            </div>
             <div class="form-group" id="imagediv"></div>
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
			 <div class="form-group" id="zipcodediv"></div>
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
               </div>
            </div>
             <div class="form-group" id="addressdiv"></div>
             <div id="childsecond" class="form-group">
             </div>
             <div id="childthird" class="form-group">
             </div>
              <div class="form-group" id="studiv"></div>	
            
            <div class="form-group">
               <label for="relationship" class="form-control-label col-sm-0">원생과의 관계</label>
               <div class="form-row">
                  <div class="col-1">
                     <input type="radio" class="form-control" id="relationship" name="relationship" value="아버지">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;아버지&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" id="relationship" name="relationship" value="어머니">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;어머니&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" id="relationship" name="relationship" value="조부모님">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;조부모&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" id="relationship" name="relationship" value="보호자님">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;기타&nbsp;</label>   
               </div>
            </div>
             <div class="form-group" id="relationshipdiv"></div>
            <br>
                <div class="form-group form-row">
            	<div class = "col-6">
               		<input type="button" class="form-control btn btn-primary" onclick="javascript:checkWrite();" value="회원가입">
               </div>
               <div class = "col-6">
               		<input type="reset" class="form-control btn btn-secondary" value="초기화">
               </div>
            </div>
         </form>
      </div>   
   </div>
   <br>
   <br>
</body>
</html>