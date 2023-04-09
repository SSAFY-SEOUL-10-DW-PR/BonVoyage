<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/include/head.jsp"%>
<link href="assets/css/login.css" rel="stylesheet" />
</head>
<% int num=0; %>
<body>

<script src="assets/js/tourinfoService.js"></script>
<script src="assets/js/map.js"></script>
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top header-transparent">
		<%@ include file="/include/nav.jsp"%>
	</header>
	<section id="route-back">
		<div class="hero-container" data-aos="fade-up">
			<div class="center" id="login">
				<div class="container">
					<div class="text" style = "font-size : 30px; font-weight : bold">내가 저장한 경로
					</div>
					<div style="margin: 15px">
<c:forEach var="route" items="${routes}">
		<div class="card col-lg-2 col-md-2"><%=++num %></div>
        <div class="card col-lg-10 col-md-10" style="display:flex; flex-direction:row">
        <div id="${route.routeId}" style="width:30%">
        </div>
        <script>
        var routeNo = 1;
        var markerPosition;
        var markerSeq = [];
        var polyline;
        var routeBounds = new kakao.maps.LatLngBounds();
        var mapContainer = document.getElementById('${route.routeId}'), // 지도를 표시할 div 
        mapOption = { 
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };
        console.log(mapContainer);
    var mapSmall = new kakao.maps.Map(mapContainer, mapOption);
    <c:forEach var="info" items="${route.routeInfo}">
    var imageSrc = `assets/img/marker/route/${routeNo}.png`; // 마커이미지의 크기입니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, new kakao.maps.Size(42, 50), { offset: new kakao.maps.Point(20, 45) });
    markerPosition = new kakao.maps.LatLng(${info.latitude}, ${info.longitude});
      var markerRoute = new kakao.maps.Marker({
        position: markerPosition, 
        image: markerImage // 마커이미지 설정 
      });
    markerRoute.setMap(mapSmall);  
    markerSeq.push(markerPosition);
    routeBounds.extend(markerPosition);
    routeNo++;
    </c:forEach>
    polyline = new kakao.maps.Polyline({
        path: markerSeq, // 선을 구성하는 좌표배열 입니다
        strokeWeight: 7, // 선의 두께 입니다
        strokeColor: 'black', // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: 'solid' // 선의 스타일입니다
      });
    polyline.setMap(mapSmall);  
    mapSmall.setBounds(routeBounds);
        </script>
        <div>
        <ol>
        <c:forEach var="info" items="${route.routeInfo}">
        	<li>${info.title}</li>
        </c:forEach>  
        </ol>
        </div>
        </div>
</c:forEach>    
					</div>


				</div>
			</div>
		</div>
	</section>
	<!-- End Hero -->

	<!-- <main id="main"></main> -->
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer"><%@ include file="/include/footer.jsp"%></footer>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
	<script src="assets/js/login.js"></script>
	<script src="assets/js/detail-Info.js"></script>
</body>
</html>
