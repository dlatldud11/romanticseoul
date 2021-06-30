<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="map" style="width:100%;height:500px;"></div>
<meta charset="UTF-8">
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=139d58a4ab00e9a3e7836d678aabdcd9"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
	center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	level: 9 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption),
customOverlay = new kakao.maps.CustomOverlay({}),
infowindow = new kakao.maps.InfoWindow({removable: true});

map.setDraggable(false);
map.setZoomable(false);

$.getJSON("resources/json/test.geojson", function(geojson){
	var data = geojson.features;
	var coordinates = []; //좌표 저장할 배열
	var name = ''; //행정 구 이름
	
	$.each(data, function(index, val){
	
		coordinates = val.geometry.coordinates;
		name = val.properties.SIG_KOR_NM;
		
		displayArea(coordinates, name);
	});
});

var polygons=[];	//function 안 쪽에 지역 변수로 넣으니깐 폴리곤 하나 생성할 때마다 배열이 비어서 클릭했을 때 전체를 못 없애줌. 그래서 전역변수로 만듦.
//행정구역 폴리곤
function displayArea(coordinates, name){
	var path = [];
	var points = [];
	
	$.each(coordinates[0], function(index, coordinate){
		var point = new Object();
		point.x = coordinate[1];
		point.y = coordinate[0];
		points.push(point);
		path.push(new kakao.maps.LatLng(coordinate[1], coordinate[0]));
	});
	
	var polygon = new kakao.maps.Polygon({
		map : map,
		path : path,
		strokeWeight : 2,
		strokeColor : '#004c80',
		strokeOpacity: 0.8,
		fillColor : '#fff',
		fillOpacity : 0.7
	});
	
	polygons.push(polygon);
	
	kakao.maps.event.addListener(polygon, 'mouseover', function(mouseEvent){
		polygon.setOptions({
			fillColor : '#09f'
		});
		
		customOverlay.setPosition(mouseEvent.letLng);
		customOverlay.setMap(map);
	});
	
	kakao.maps.event.addListener(polygon, 'mousemove', function(mouseEvent){
		customOverlay.setPosition(mouseEvent.latLng);
	});
	
	kakao.maps.event.addListener(polygon, 'mouseout', function(){
		polygon.setOptions({
			fillColor : '#fff'
		});
		customOverlay.setMap(map);
	});
	kakao.maps.event.addListener(polygon, 'click', function(mouseEvent) {
        var content = '<div class="info">' + 
                    '<div class="title">' + name + '</div>';
        $("#guName").empty(name);
        $("#guName").append(name);
        infowindow.setContent(content); 
        infowindow.setPosition(mouseEvent.latLng); 
        infowindow.setMap(map);
	    var gu = name;
        ajaxstart(gu);
        
   	});
}
</script>

<script>
function ajaxstart(gu){
	$.ajax({
		url : "${applicationScope.contextPath}/gulist.ma",
	data : {'gu':gu},
	type : "POST",
	datatype : 'json',
	success : function(data) {
		//alert('구선택완료');
		console.log(data);
		location.href = "${applicationScope.contextPath}/main.co";
		},
	eroor:function(request,status,error){
		alert('error');
	}
	});
}
</script>