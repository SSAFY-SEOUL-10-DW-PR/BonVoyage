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
          <div class="board_wrap" id="edit">
            <div class="board_title">
              <strong>공지사항</strong>
              <p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
            </div>
            <div class="board_write_wrap">
              <div class="board_write">
                <div class="title">
                  <dl>
                    <dt>제목</dt>
                    <dd>
                      <input type="text" placeholder="제목 입력" value="" />
                    </dd>
                  </dl>
                </div>
                <div class="info">
                  <dl>
                    <dt>글쓴이</dt>
                    <dd><input type="text" placeholder="글쓴이 입력" value="" /></dd>
                  </dl>
                  <dl>
                    <dt>비밀번호</dt>
                    <dd><input type="password" placeholder="비밀번호 입력" value="" /></dd>
                  </dl>
                </div>
                <div class="cont">
                  <textarea placeholder="내용 입력"></textarea>
                </div>
              </div>
              <div class="bt_wrap">
                <a href="community-view.jsp" class="on">수정</a>
                <a href="community-view.jsp">취소</a>
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
