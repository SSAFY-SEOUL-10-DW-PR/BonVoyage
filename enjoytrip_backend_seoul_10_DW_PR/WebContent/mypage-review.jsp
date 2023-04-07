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
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top header-transparent">
		<%@ include file="/include/nav.jsp"%>
	</header>
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="login-back">
		<div class="hero-container" data-aos="fade-up">
			<div class="center" id="login">
				<div class="container">
					<div class="text" style = "font-size : 30px; font-weight : bold"> 내가 작성한 리뷰
					</div>
					<div>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">장소</th>
      <th scope="col">리뷰 내용</th>
      <th scope="col">작성날짜</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="review" items="${reviews}">
<tr>
      <th scope="row"><%=num++ %></th>
      <td>${review.location }</td>
      <td>${review.reviewContent}</td>
      <td>${review.writeDate }</td>
    </tr>
</c:forEach>    
  </tbody>
</table>
					</div>
					<div>
					
					</div>
					<div>
					
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
