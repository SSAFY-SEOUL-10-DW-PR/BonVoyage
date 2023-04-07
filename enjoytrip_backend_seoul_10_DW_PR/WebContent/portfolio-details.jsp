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
                <h3>${title}</h3>
  <ul>
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
                </ul>
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
          <script>
    const exampleModal = document.getElementById('exampleModal');
    exampleModal.addEventListener('show.bs.modal', event => {
      // Button that triggered the modal
      const button = event.relatedTarget;
      // Extract info from data-bs-* attributes
      const recipient = button.getAttribute('data-bs-whatever');
      // If necessary, you could initiate an AJAX request here
      // and then do the updating in a callback.
      //
      // Update the modal's content.
      const modalTitle = exampleModal.querySelector('.modal-title');
      const modalBodyInput = exampleModal.querySelector('.modal-body input');

      modalTitle.textContent = `New message to ${recipient}`;
      modalBodyInput.value = recipient;
    });
</script>
<button type="button" style="margin: auto; display: block" class="btn btn-outline-info mt-3" data-aos="fade-up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">리뷰 작성하기</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">New Review for ${title}</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="${root}/review?action=write">
          <div class="mb-3">
        <input type="hidden" name="contentId" value="${tripDetail.contentid}">
        <input type="hidden" name="contentTypeId" value="${tripDetail.contenttypeid}">
        <input type="hidden" name="title" value="${title}">
            <label for="message-text" class="col-form-label">한줄 리뷰 남기기:</label>
            <textarea class="form-control" id="message-text" name="reviewContent"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">저장하기</button>
      </div>
    </div>
  </div>
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
<<<<<<< HEAD
    <script>
console.log("${title}");
console.log("${reviewers}");
</script>
=======

>>>>>>> review
  </body>
</html>
    