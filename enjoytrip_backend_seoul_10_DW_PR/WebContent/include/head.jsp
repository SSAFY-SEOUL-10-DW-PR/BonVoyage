<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<title>Bon Voyage</title>
<meta content="" name="description" />
<meta content="" name="keywords" />

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon" />
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
  rel="stylesheet"
/>

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet" />
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet" />
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
<link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet" />
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" />

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet" />

<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
<script>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>