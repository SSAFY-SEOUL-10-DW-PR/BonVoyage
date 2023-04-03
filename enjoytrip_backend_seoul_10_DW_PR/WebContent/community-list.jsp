<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
	<%@ include file="/include/head.jsp" %>
    <link rel="stylesheet" href="assets/css/sort-list.css" />
    <link rel="stylesheet" href="assets/css/community.css" />
  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top header-transparent">
	<%@ include file="/include/nav.jsp" %>
    </header>
    <!-- End Header -->

    <section id="bg">
      <div class="hero-container" data-aos="fade-up">
        <main id="main">
          <div class="board_wrap" id="list">
            <div class="board_title">
              <strong>공지사항</strong>
              <p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
            </div>
            <div class="board_list_wrap">
              <div class="board_list">
                <div class="top">
                  <div class="num">번호</div>
                  <div class="title">제목</div>
                  <div class="writer">글쓴이</div>
                  <div class="date">작성일</div>
                  <div class="count">조회</div>
                </div>
                <div>
                  <div class="num">5</div>
                  <div class="title"><a href="community-view.jsp">글 제목이 들어갑니다.</a></div>
                  <div class="writer">김이름</div>
                  <div class="date">2023.3.17</div>
                  <div class="count">33</div>
                </div>
                <div>
                  <div class="num">4</div>
                  <div class="title"><a href="community-view.jsp">글 제목이 들어갑니다.</a></div>
                  <div class="writer">김이름</div>
                  <div class="date">2023.3.17</div>
                  <div class="count">33</div>
                </div>
                <div>
                  <div class="num">3</div>
                  <div class="title"><a href="community-view.jsp">글 제목이 들어갑니다.</a></div>
                  <div class="writer">김이름</div>
                  <div class="date">2023.3.17</div>
                  <div class="count">33</div>
                </div>
                <div>
                  <div class="num">2</div>
                  <div class="title"><a href="community-view.jsp">글 제목이 들어갑니다.</a></div>
                  <div class="writer">김이름</div>
                  <div class="date">2023.3.17</div>
                  <div class="count">33</div>
                </div>
                <div>
                  <div class="num">1</div>
                  <div class="title"><a href="community-view.jsp">글 제목이 들어갑니다.</a></div>
                  <div class="writer">김이름</div>
                  <div class="date">2023.3.17</div>
                  <div class="count">33</div>
                </div>
              </div>
              <div class="board_page">
                <a href="#" class="bt first"><<</a>
                <a href="#" class="bt prev"><</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="num">4</a>
                <a href="#" class="num">5</a>
                <a href="#" class="bt next">></a>
                <a href="#" class="bt last">>></a>
              </div>
              <div class="bt_wrap">
                <a href="community-write.jsp" class="on" onclick="write()">등록</a>
                <!-- <a href="#">수정</a> -->
              </div>
            </div>
          </div>
        </main>
        <!-- End #main -->
      </div>
    </section>

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
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a65b4ab11f68e42b50252010e043419b"
    ></script>
    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>
    <script src="assets/js/login.js"></script>
  </body>
</html>