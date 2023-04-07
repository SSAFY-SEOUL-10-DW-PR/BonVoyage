<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
  <head>
	<%@ include file="/include/head.jsp" %>
  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top">
	<%@ include file="/include/nav.jsp" %>
    </header>
    <!-- End Header -->

    <main id="main">
      <!-- ======= Breadcrumbs Section ======= -->
      <section class="breadcrumbs">
        <div class="container">
          <div class="d-flex justify-content-between align-items-center">
            <h2>Location Details</h2>
            <ol>
              <li><a href="index.jsp">Home</a></li>
              <li><a href="index.jsp#portfolio">Recommend</a></li>
              <li>Location Details</li>
            </ol>
          </div>
        </div>
      </section>
      <!-- Breadcrumbs Section -->

      <!-- ======= Portfolio Details Section ======= -->
      <section id="portfolio-details" class="portfolio-details">
        <div class="container">
          <div class="row gy-4">
            <div class="col-lg-8">
              <div class="portfolio-details-slider swiper">
                <div class="swiper-wrapper align-items-center" id="img">
<c:forEach var="imgs" items="${tripImg}">
<div class="swiper-slide">
    <img src="${imgs.originimgurl}" alt="" />
  </div>
</c:forEach>
                </div>
                <div class="swiper-pagination"></div>
              </div>
            </div>

            <div class="col-lg-4" id="">
              <div class="portfolio-info" id="location-info">
                <c:if test="${tripDetail.contenttypeid eq 12}">
                <li><strong>분류</strong> : 관광지</li>
        <li><strong>이용 문의</strong> : ${tripDetail.infocenter}</li>
        <li><strong>휴무일</strong> : ${tripDetail.restdate}</li>
        <li><strong>이용 시간</strong> : ${tripDetail.usetime}</li>
        <li><strong>주차 가능 여부</strong> : ${tripDetail.parking}</li>
                </c:if>
                <c:if test="${tripDetail.contenttypeid eq 32}">
                <li><strong>분류</strong> : 숙박시설</li>
        <li><strong>방 개수</strong> : ${tripDetail.roomcount}</li>
        <li><strong>체크인 / 체크아웃</strong> : ${tripDetail.checkintime} ~ ${tripDetail.checkouttime}</li>
        <li><strong>편의 시설</strong> : ${tripDetail.subfacility}</li>
                </c:if>
                <c:if test="${tripDetail.contenttypeid eq 39}">
                <li><strong>분류</strong> : 음식점</li>
        <li><strong>주 메뉴</strong> : ${tripDetail.treatmenu}</li>
        <li><strong>전화번호</strong> : ${tripDetail.infocenterfood}</li>
        <li><strong>이용 시간</strong> : ${tripDetail.opentimefood}</li>
        <li><strong>휴무일</strong> : ${tripDetail.restdatefood}</li>
                </c:if>
                <!-- <h3>Project information</h3>
                <ul>
                  <li><strong>Category</strong>: Web design</li>
                  <li><strong>Client</strong>: ASU Company</li>
                  <li><strong>Project date</strong>: 01 March, 2020</li>
                  <li><strong>Project URL</strong>: <a href="#">www.example.com</a></li>
                </ul> -->
              </div>
              <div class="portfolio-description">
                <h2>상세 정보</h2>
                <p id="description">
                    ${desc }
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- End Portfolio Details Section -->

      <!-- ======= Testimonials Section ======= -->
      <section id="testimonials" class="testimonials section-bg">
        <div class="container">
          <div class="section-title" data-aos="fade-in" data-aos-delay="100">
            <h2>리뷰</h2>
          </div>

          <div class="testimonials-slider swiper" data-aos="fade-up" data-aos-delay="100">
            <div class="swiper-wrapper">
            <c:forEach var="reviewer" items="${reviewers}">
              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    ${reviewer.reviewContent}
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img
                    src="assets/img/testimonials/${reviewer.sex}.png"
                    class="testimonial-img"
                    alt=""
                  />
                  <h3>${reviewer.name }</h3>
                  <h4>${reviewer.age } 대</h4>
                </div>
              </div>
</c:forEach>
            

              <!-- End testimonial item -->
            </div>
            <div class="swiper-pagination"></div>
          </div>
        </div>
      </section>
      <!-- End Testimonials Section -->
    </main>
    <!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer">
	<%@ include file="/include/footer.jsp" %>
    </footer>
    <!-- End Footer -->

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

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
    <script>
console.log("${title}");
console.log("${reviewers}");
</script>
  </body>
</html>
    