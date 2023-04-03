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
                  <script>
                    document.getElementById("img").innerHTML = localStorage.getItem("img");
                  </script>
                  <!-- <div class="swiper-slide">
                    <img src="assets/img/portfolio/portfolio-1.jpg" alt="" />
                  </div>

                  <div class="swiper-slide">
                    <img src="assets/img/portfolio/portfolio-2.jpg" alt="" />
                  </div>

                  <div class="swiper-slide">
                    <img src="assets/img/portfolio/portfolio-3.jpg" alt="" />
                  </div> -->
                </div>
                <div class="swiper-pagination"></div>
              </div>
            </div>

            <div class="col-lg-4" id="">
              <div class="portfolio-info" id="location-info">
                <script>
                  document.getElementById("location-info").innerHTML = localStorage.getItem("info");
                </script>
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
                  <script>
                    document.getElementById("description").innerHTML = localStorage.getItem("desc");
                  </script>
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
              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    좋은 경험이었습니다!
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img
                    src="assets/img/testimonials/profile (1).png"
                    class="testimonial-img"
                    alt=""
                  />
                  <h3>강백호</h3>
                  <h4>Ceo &amp; Founder</h4>
                </div>
              </div>
              <!-- End testimonial item -->

              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    좋고편리하네요 최고입니다
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img src="assets/img/testimonials/profile.png" class="testimonial-img" alt="" />
                  <h3>서태웅</h3>
                  <h4>Designer</h4>
                </div>
              </div>
              <!-- End testimonial item -->

              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    가기 편하고 구경거리가 많아요
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img src="assets/img/testimonials/girl.png" class="testimonial-img" alt="" />
                  <h3>송태섭</h3>
                  <h4>Store Owner</h4>
                </div>
              </div>
              <!-- End testimonial item -->

              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    방학시즌이라 사람들이 많았지만 괜찮았어요
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img src="assets/img/testimonials/man.png" class="testimonial-img" alt="" />
                  <h3>정대만</h3>
                  <h4>Freelancer</h4>
                </div>
              </div>
              <!-- End testimonial item -->

              <div class="swiper-slide">
                <div class="testimonial-item">
                  <p>
                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                    아이들이 너무 좋아했어요 집에서 가깝고 주변에 식당도 많아 좋았어요
                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                  </p>
                  <img src="assets/img/testimonials/woman.png" class="testimonial-img" alt="" />
                  <h3>채치수</h3>
                  <h4>Entrepreneur</h4>
                </div>
              </div>
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
  </body>
</html>
    