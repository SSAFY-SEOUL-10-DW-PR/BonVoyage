<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/include/head.jsp"%>
<link href="assets/css/login.css" rel="stylesheet" />
</head>

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
					<div class="text" style = "font-size : 30px; font-weight : bold">
						사용자 정보
					</div>
					<form name="info_form" action="${root}/user" method="post"
						id="signIn">
						<input type="hidden" name="action" value="modify" />
						<div>
							<label>비밀번호<input type="password"
								name="pwd" id="pwd" placeholder="영문자+숫자+특수문자 최소 8자리" value="${userinfo.pw}"/></label>
						</div>
						<div>
							<label>비밀번호 재확인<input type="password" name="repwd"
								id="repwd" value="${userinfo.pw}"/></label>
						</div>
						<div>
							<label>이름<input type="text" name="uname" id="uname" value="${userinfo.name}" /></label>
						</div>
						<div>
							<label> 
								생년월일<input type="text" name="birth" id="birth" placeholder="년(4자)"
								value="${userinfo.birth}"/> 
							</label> 
						</div>
						<div>
							<select name="question" id="question">
								<!--onchage: select안에 있는 옵션들의 값이 바꼈을때 명령이 실행
                   onclick을 안하는 이유: 키보드 사용자는 click을 할수 없으므로-->
								<option selected>${userinfo.question}</option>
								<option value="기억에 남는 추억의 장소는?">기억에 남는 추억의 장소는?</option>
								<option value="자신의 인생 좌우명은?">자신의 인생 좌우명은?</option>
								<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
								<option value="타인이 모르는 자신만의 신체비밀이 있다면?">타인이 모르는 자신만의
									신체비밀이 있다면?</option>
								<option value="추억하고 싶은 날짜가 있다면?">추억하고 싶은 날짜가 있다면?</option>
								<option value="받았던 선물 중 기억에 남는 독특한 선물은?">받았던 선물 중 기억에
									남는 독특한 선물은?</option>
								<option value="유년시절 가장 생각나는 친구 이름은?">유년시절 가장 생각나는 친구
									이름은?</option>
								<option value="인상 깊게 읽은 책 이름은?">인상 깊게 읽은 책 이름은?</option>
								<option value="자신이 두번째로 존경하는 인물은?">자신이 두번째로 존경하는 인물은?</option>
								<option value="친구들에게 공개하지 않은 어릴 적 별명이 있다면?">친구들에게 공개하지
									않은 어릴 적 별명이 있다면?</option>
								<option value="초등학교 때 기억에 남는 짝꿍 이름은?">초등학교 때 기억에 남는 짝꿍
									이름은?</option>
								<option value="다시 태어나면 되고 싶은 것은?">다시 태어나면 되고 싶은 것은?</option>
								<option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
							</select> <input type="text" name="answer" id="answer" value="${userinfo.answer}"
								placeholder="비밀번호  질문 답변" />
						</div>
						<%--
              <div>
                <!--radio버튼은 둘 중의 하나만 선택하려면 name값을 같게 줘야함
                  radio 버튼은 DB저장과 상관이 없음 value="" 따로 값을 넣어서 DB 값이 전송됨
                  radio 버튼은 id값을 하나만 설정이 가능하므로 radio 경우만 id값 다르게 설정-->
                성별<input type="radio" value="F" name="gender" id="female" />여
                <!--"여"에 미리 체크되있을 경우<input type="radio" value="F" name="sex" id="female" checked>여-->
                <input type="radio" value="M" name="gender" id="male" />남
              </div>
              --%>
						<div>
							<label>전화번호<input type="tel"
								name="mobile" id="mobile" value="${userinfo.phone}"/>
							</label>
						</div>
						<div>
							<label>이메일<input type="text" name="email_id"
								id="email_id" value="${userinfo.email}"/>
						</div>
						<div class="join_btn">
							<button type="button" onclick="withdrawal();" style="background-color : red">회원 탈퇴</button>
							<!-- (window삭제).history.back 뒤로가기/history.forward 앞으로가기-->
							<button type="button" onclick="modify();">수정</button>
							<!-- 입력된 경우에 따라서 다르게 액션되면 button으로, 입력 값 상관 없이 무조건 보내기면 submit -->
							<!-- type을 submit으로 하여 전송하기를 하지말고, script가서 함수를 만들고 전송하기를 함 button onclick으로 함수를 불러옴 함수안에 문제가 있는 경우 return false;-->
						</div>
						
						<script>
						function withdrawal(){
							if(confirm("정말로 탈퇴하시겠습니까?")){
								alert("탈퇴 완료");
								location.href = "${root}/user?action=delete";
							}
						}
						function modify(){
							if(document.querySelector("#pwd").value != document.querySelector("#repwd").value) {
								alert("비밀번호가 일치하지 않습니다.")
								return;
							}
							if(confirm("회원 정보를 수정하시겠습니까?")){
								alert("수정 완료");
								document.info_form.submit();
							}
						}
						</script>
						
					</form>
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