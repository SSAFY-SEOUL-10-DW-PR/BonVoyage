<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="/include/head.jsp" %>
    <link rel="stylesheet" href="assets/css/sort-list.css" />
  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top header-transparent">
      <%@ include file="/include/nav.jsp" %>
    </header>
    <!-- End Header -->

    <!-- ======= Hero Section ======= -->
    <section id="hero">
      <div class="hero-container" data-aos="fade-up">
        <!-- <h1>Welcome to Squad</h1>
        <h2>We are team of talented designers making websites with Bootstrap</h2> -->
        <a href="#about" class="btn-get-started scrollto"><i class="bx bx-chevrons-down"></i></a>
      </div>
    </section>
    <!-- End Hero -->
    
    <main id="main">
      <!-- ======= About Section ======= -->
      <section id="about" class="about">
        <div class="container">
          <div class="row no-gutters">
            <div class="content col-xl-5 d-flex align-items-stretch" data-aos="fade-up">
              <div class="content">
                <h3>간편한 여행 계획 플래너</h3>
                <p>복잡한 여행 계획 없이 지금 바로 출발하세요!</p>
                <a href="#contact" class="about-btn"
                  >Go To Plan <i class="bx bx-chevron-right"></i
                ></a>
              </div>
            </div>
            <div class="col-xl-7 d-flex align-items-stretch">
              <div class="icon-boxes d-flex flex-column justify-content-center">
                <div class="row">
                  <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="100">
                    <i class="bx bx-receipt"></i>
                    <h4>맞춤형 여행 컨셉</h4>
                    <p>#식도락 #혼자가 편해요 #가족과 함께</p>
                  </div>
                  <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="200">
                    <i class="bx bx-cube-alt"></i>
                    <h4>복잡한 여행 계획 없이</h4>
                    <p>일단 출발하고 계획 수립해도 OK</p>
                  </div>
                  <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="300">
                    <i class="bx bx-images"></i>
                    <h4>깔끔한 인터페이스</h4>
                    <p>누구나 사용 가능한 간단한 인터페이스</p>
                  </div>
                  <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="400">
                    <i class="bx bx-shield"></i>
                    <h4>국내 숨겨진 명소 구석구석</h4>
                    <p>전국 곳곳의 관광지는 물론, 숙박, 음식점까지 한번에!</p>
                  </div>
                </div>
              </div>
              <!-- End .content-->
            </div>
          </div>
        </div>
      </section>
      <!-- End About Section -->

      <!-- ======= Services Section ======= -->
      <script>
        function setAreaCode(select) {
          document.getElementById("dropdownMenuOffset").innerHTML = select.textContent;
          document.getElementById("dropdownMenuOffset").value = select.value;
        }
        function setSigungu(select) {
          document.getElementById("dropdownMenu").innerHTML = select.textContent;
          document.getElementById("dropdownMenu").value = select.value;
        }
      </script>
      <section id="services" class="services">
        <div class="container">
          <div class="section-title" data-aos="fade-in" data-aos-delay="100">
            <h2>어디로 여행을 계획중이신가요?</h2>
            <div class="d-flex" style="display: flex; flex-direction: column">
              <div class="dropdown-group mb-3" style="display: flex; justify-content: center">
                <div class="dropdown me-5">
                  <!-- 시도 구군 검색 -->
                  <button
                    type="button"
                    class="btn btn-outline-secondary dropdown-toggle"
                    id="dropdownMenuOffset"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                    data-bs-offset="10,20"
                  >
                    시/도 분류
                  </button>
                  <ul class="dropdown-menu" id="area-category" aria-labelledby="dropdownMenuOffset">
                    <li class="dropdown-item" value="0" onclick="setAreaCode(this)">선택안함</li>
                  </ul>
                </div>
                <div class="dropdown">
                  <button
                    type="button"
                    class="btn btn-outline-secondary dropdown-toggle"
                    id="dropdownMenu"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                    data-bs-offset="10,20"
                  >
                    군/구 분류
                  </button>
                  <ul
                    class="dropdown-menu"
                    id="sigungu-category"
                    aria-labelledby="dropdownMenuOffset"
                  >
                    <li class="dropdown-item" value="0" onclick="setSigungu(this)">선택안함</li>
                  </ul>
                </div>
              </div>
              <div class="form-group has-search mb-5">
                <span class="fa fa-search form-control-feedback"></span>
                <div class="input-group">
                  <input
                    id="search-keyword"
                    type="search"
                    style="width: 100px"
                    size="40"
                    class="form-control rounded"
                    placeholder="Search"
                    aria-label="Search"
                  />
                  <button type="button" class="btn btn-outline-secondary" id="btn-search-keyword">
                    search
                  </button>
                </div>
              </div>

              <div style="margin: 0 auto; display: flex; justify-content: center">
                <div style="height: 600px; overflow-y: scroll">
                  <table class="table table-striped me-3" style="width: 300px">
                    <thead>
                      <tr>
                        <th>No.</th>
                        <th>관광지명</th>
                        <th>주소</th>
                      </tr>
                    </thead>
                    <tbody id="trip-list"></tbody>
                  </table>
                </div>
                <div id="map" style="width: 800px; height: 600px"></div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- End Services Section -->

      <!-- ======= Portfolio Section ======= -->
      <section id="portfolio" class="portfolio">
        <div class="container">
          <div class="section-title" data-aos="fade-in" data-aos-delay="100">
            <h2>장소 추천</h2>
            <p>
              이미지에 마우스를 올린 후 일정표에 추가하거나 해당 장소에 대한 상세 정보를 확인할 수
              있습니다.
            </p>
          </div>

          <div class="row" data-aos="fade-in">
            <div class="col-lg-12 d-flex justify-content-center">
              <ul id="portfolio-flters">
                <li data-filter="*" class="filter-active">전체</li>
                <li data-filter=".filter-attraction">관광지</li>
                <li data-filter=".filter-accommodation">숙박</li>
                <li data-filter=".filter-restaurant">맛집</li>
              </ul>
            </div>
          </div>

          <div id="recommend-list">
            <div
              class="row portfolio-container"
              id="portfolio-container"
              name="portfolio-container"
              data-aos="fade-up"
            ></div>
          </div>
        </div>
      </section>
      <!-- End Portfolio Section -->

      <!-- ======= Contact Section ======= -->

      <section id="contact" class="contact section-bg">
        <div class="container" data-aos="fade-up">
          <div class="section-title">
            <h2>내 여행 일정 확인하기</h2>
            <p>저장한 여행지들을 한눈에 확인할 수 있습니다.</p>
          </div>

          <form method="post" id="routeForm" action="${root}/route?action=save">
          <div class="row">
            <div class="col-lg-9" style="height: 600px" id="map-route"></div>
            <div class="col-lg-3">
            <!-- <input type="hidden" name="action" value="save"> -->
              <ul id="sortlist"></ul>
            </div>
            <div style="display:flex; justify-content:center; flex-direction: row; padding:0px">
            <button type="button" class="btn btn-outline-secondary" id="routeView" style="margin:15px 10px 15px 0px; width:100%">경로보기</button>
            <button type="submit" class="btn btn-outline-success" id="routeSave" style="margin:15px 0px 15px 10px; width:100%">경로저장</button> 
            </div>
            <button type="button" class="btn btn-outline-info" id="routeLatestView" >최근 저장한 경로 불러오기</button>
          </div>
         </form>
        </div>
        <script></script>
      </section>
      <!-- End Contact Section -->
    </main>
    <!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer"><%@ include file="/include/footer.jsp" %></footer>
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
    <script src="assets/js/map.js"></script>
    <script src="assets/js/tourInfoService.js"></script>
    <script src="assets/js/recommendService.js"></script>
    <script src="assets/js/tourRouteService.js"></script>
    <script src="assets/js/detail-Info.js"></script>
    <script src="assets/js/login.js"></script>
  </body>
</html>
