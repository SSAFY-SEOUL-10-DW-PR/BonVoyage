<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
      <div class="container d-flex align-items-center justify-content-between position-relative">
        <div class="logo">
          <h1 class="text-light">
            <a href="index.jsp"
              ><span><img src="assets/img/logo.png" alt="" /></span
            ></a>
          </h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar">
          <ul>
            <li><a class="nav-link scrollto active" href="index.jsp#hero">Home</a></li>
            <li><a class="nav-link scrollto" href="index.jsp#about">About Us</a></li>
            <li><a class="nav-link scrollto" href="index.jsp#services">Search</a></li>
            <li><a class="nav-link scrollto" href="index.jsp#portfolio">Recommend</a></li>
            <li><a class="nav-link scrollto" href="community-list.jsp">Community</a></li>
            <!-- <li class="dropdown">
              <a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
              <ul>
                <li><a href="#">Drop Down 1</a></li>
                <li class="dropdown">
                  <a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="#">Deep Drop Down 1</a></li>
                    <li><a href="#">Deep Drop Down 2</a></li>
                    <li><a href="#">Deep Drop Down 3</a></li>
                    <li><a href="#">Deep Drop Down 4</a></li>
                    <li><a href="#">Deep Drop Down 5</a></li>
                  </ul>
                </li>
                <li><a href="#">Drop Down 2</a></li>
                <li><a href="#">Drop Down 3</a></li>
                <li><a href="#">Drop Down 4</a></li>
              </ul>
            </li>
            <li class="dropdown megamenu">
              <a href="#"><span>Mega Menu</span> <i class="bi bi-chevron-down"></i></a>
              <ul>
                <li>
                  <strong>Column 1</strong>
                  <a href="#">Column 1 link 1</a>
                  <a href="#">Column 1 link 2</a>
                  <a href="#">Column 1 link 3</a>
                </li>
                <li>
                  <strong>Column 2</strong>
                  <a href="#">Column 2 link 1</a>
                  <a href="#">Column 2 link 2</a>
                  <a href="#">Column 3 link 3</a>
                </li>
                <li>
                  <strong>Column 3</strong>
                  <a href="#">Column 3 link 1</a>
                  <a href="#">Column 3 link 2</a>
                  <a href="#">Column 3 link 3</a>
                </li>
                <li>
                  <strong>Column 4</strong>
                  <a href="#">Column 4 link 1</a>
                  <a href="#">Column 4 link 2</a>
                  <a href="#">Column 4 link 3</a>
                </li>
                <li>
                  <strong>Column 5</strong>
                  <a href="#">Column 5 link 1</a>
                  <a href="#">Column 5 link 2</a>
                  <a href="#">Column 5 link 3</a>
                </li>
              </ul>
            </li> -->
            <li><a class="nav-link scrollto" href="index.jsp#contact">plan</a></li>
            <li><a class="nav-link scrollto" href="${root}/user?action=mvlogin" id="Login">Login</a></li>
            <li>
              <a
                class="nav-link scrollto"
                href="${root}/user?action=logout"
                id="Logout"
                style="display: none"
                onclick="Logout()"
                >Logout</a
              >
            </li>
            <li>
              <a class="nav-link scrollto" href="" id="Mypage" style="display: none">Mypage</a>
            </li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>
        <!-- .navbar -->
      </div>
      
      
      
<script>
	<c:if test="${!empty userInfo}">
	  document.getElementById("Logout").style.display = "block";
	  document.getElementById("Mypage").style.display = "block";
	  document.getElementById("Login").style.display = "none";
	</c:if>
</script>