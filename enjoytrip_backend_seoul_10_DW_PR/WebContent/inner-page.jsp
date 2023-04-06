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
					<div class="text">
						<img src="assets/img/black_logo.png" alt="" />
					</div>
					<form method="POST" action="${root}/user" id="authenticate_form">
						<input type="hidden" name="action" value="login" />
						<div class="form-container" id="logininit">
							<div class="data" id="id">
								<label id="email">아이디</label> <input type="text" id="LoginId"
									name="id" required />
							</div>
							<table>
								<div class="data" id="newPwd" style="display: none">
									<label>새 비밀번호</label> <input type="password" id="newPassword"
										name="newPassword" />
								</div>
								<div class="data" id="newRePwd" style="display: none">
									<label>비밀번호 확인</label> <input type="password" id="newRePassword"
										name="newRePassword" />
								</div>
							</table>
							<div name="find" id="find" style="display: none">
								<select name="findQuestion" id="findQuestion">
									<!--onchage: select안에 있는 옵션들의 값이 바꼈을때 명령이 실행
                   onclick을 안하는 이유: 키보드 사용자는 click을 할수 없으므로-->
									<option disabled selected>비밀번호 확인 질문을 선택하세요</option>
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
								</select> <input type="text" name="findAnswer" id="findAnswer"
									placeholder="비밀번호  질문 답변" />
								<%-- 
                  <label id="mailCodePw">이메일</label>
                  <input type="text" id="findemail" name="findemail" />
              --%>
							</div>
							<div class="data" id="LoginPassword">
								<label>비밀번호</label> <input type="password" id="LoginPwd"
									name="pw"
									onKeypress="javascript:if(event.keyCode==13) {Login()}"
									required />
							</div>
							<div class="btn">
								<div class="inner"></div>
								<button type="submit" id="LoginBtn">로그인</button>
								<button type="button" onclick="next()" id="next-btn"
									style="display: none">다음</button>
								<button type="button" onclick="checkQuestion()" id="findQ-btn"
									style="display: none">제출하기</button>
								<button type="button" onclick="resetpwd()" id="pwdreset-btn"
									style="display: none">비밀번호 변경</button>
								<span></span>
								<%-- 
                  <button type="button" onclick="sendCode()" id="sendAuthenticCode-btn" style = "display : none">인증번호 전송</button>
                  <button type="button" onclick="putCode()" id="putAuthenticCode-btn" style = "display : none">인증번호 입력</button>
                  <button type="button" onclick="newPassword()" id="newPw-btn" style = "display : none">비밀번호 변경</button>
              --%>
							</div>
							<div class="forgot-pass">
								<%--${root}/user?action=findPassword --%>
								<a href="#" onclick="ForgotPassword()" id="passwordquery">비밀번호를
									잊으셨나요?</a>
								<script>
        function ForgotPassword(){
      	  document.querySelector("#LoginPassword").style.display ="none";
    	  document.querySelector("#LoginBtn").style.display ="none";
    	  document.querySelector("#next-btn").style.display ="block";
    	  document.querySelector("#passwordquery").style.display ="none";
        }
        
        function next(){
          let form = document.querySelector("#authenticate_form");
          form.setAttribute("action", "${root}/user?action=findID");
          form.submit(); //유효성 검사의 포인트
        }

        function checkQuestion(){
        let form = document.querySelector("#authenticate_form");
        form.setAttribute("action", "${root}/user?action=checkQuestion");
    	 form.submit(); //유효성 검사의 포인트
        }
        
        function resetpwd() {
        	var newpwd = document.querySelector("#newPassword").value
        	if(newpwd == document.querySelector("#newRePassword").value){
        		if(document.querySelector("#newPassword").value.length < 8) {
        			alert("비밀번호를 8자리 이상 입력하세요.");
        			return;
        		}
        		//비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
        		  var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

        		  if (!pwdCheck.test(newpwd)) {
        		    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
        		    pwd.focus();
        		    return false;
        		  }
            let form = document.querySelector("#authenticate_form");
            form.setAttribute("action", "${root}/user?action=changepw");
        	 form.submit();
        	} else alert("비밀번호가 일치하지 않습니다.")
        }
        

      	<c:if test="${!empty result}">
      	alert("비밀번호 변경 완료!");
    	<%session = request.getSession();
		session.removeAttribute("result");%>
    	</c:if>
        
      	<c:if test="${!empty findFlag}">
    	  document.querySelector("#id").style.display ="none";
  	  document.querySelector("#next-btn").style.display ="none";
    	  document.querySelector("#findQ-btn").style.display ="block";
  	  document.querySelector("#find").style.display ="block";
  	  document.querySelector("#LoginPassword").style.display ="none";
	  document.querySelector("#LoginBtn").style.display ="none";
	  document.querySelector("#passwordquery").style.display ="none";
	  
    	<%session = request.getSession();
		session.removeAttribute("findFlag");%>
    	</c:if>

      	<c:if test="${!empty IdNotFound}">
      	alert("${IdNotFound}");
      	<%session = request.getSession();
				session.removeAttribute("IdNotFound");%>
    	</c:if>
    	
      	<c:if test="${!empty checkFlag}">
      	  document.querySelector("#LoginPassword").style.display ="none";
    	  document.querySelector("#id").style.display ="none";
    	  document.querySelector("#find").style.display ="none";
    	  document.querySelector("#LoginBtn").style.display ="none";
    	  document.querySelector("#findQ-btn").style.display ="none";
    	  document.querySelector("#newPwd").style.display ="block";
    	  document.querySelector("#newRePwd").style.display ="block";
    	  document.querySelector("#passwordquery").style.display ="none";
      	  document.querySelector("#pwdreset-btn").style.display ="block";
    	  
        	<%session = request.getSession();
				session.removeAttribute("checkFlag");%>
    	</c:if>

      	<c:if test="${!empty questionError}">
      	alert("${questionError}");
      	<%session = request.getSession();
				session.removeAttribute("questionError");%>
    	</c:if>
    	<%-- 
              function ForgotPassword(){

            	  document.querySelector("#LoginPassword").style.display ="none";
            	  document.querySelector("#id").style.display ="none";
            	  document.querySelector("#findmail").style.display ="block";
            	  document.querySelector("#passwordquery").style.display ="none";
            	  document.querySelector("#LoginBtn").style.display ="none";
            	  document.querySelector("#sendAuthenticCode-btn").style.display ="inline";
              }
              function sendCode(){
              --%>
            	  <%--document.querySelector("#sendAuthenticCode").style.display ="none";--%>
            	  <%--document.querySelector("#sendAuthenticCode-btn").innerHTML = "재전송"
                  document.querySelector("#mailCodePw").innerHTML = "인증번호"
            	  document.querySelector("#putAuthenticCode-btn").style.display ="inline";
                  let form = document.querySelector("#authenticate_form");
                  form.setAttribute("action", "${root}/user?action=findPwSendEmail&email="+document.querySelector("#findemail").value);
          	  form.submit(); //유효성 검사의 포인트
              }

              function putCode(){
        	  	location.href= "${root}/user?action=findPassword ";
              }
              
              function newPassword(){
          	  	location.href= "${root}/user?action=findPassword ";
                }
              --%>
              </script>
							</div>
							<div class="signup-link">
								회원이 아니세요? <a href="#" onclick="Signin()">회원가입하기</a>
							</div>
						</div>
					</form>
					<form name="join_form" action="${root}/user" method="post"
						id="signIn" style="display: none">
						<input type="hidden" name="action" value="join" />
						<div>
							<label>아이디<input type="text" name="uid" id="uid" /></label>
							<!-- <button type="button" onclick="id_check();">중복확인</button> -->
						</div>
						<div>
							<label>비밀번호<input type="password"
								name="pwd" id="pwd" placeholder="영문자+숫자+특수문자 최소 8자리" /></label>
						</div>
						<div>
							<label>비밀번호 재확인<input type="password" name="repwd"
								id="repwd" /></label>
						</div>
						<div>
							<label>이름<input type="text" name="uname" id="uname" /></label>
						</div>
						<div>
							<label> <!--생년월일 예전에는 option 형식이었지만 현재는 text type으로 변경 추세-->
								생년월일<input type="text" name="yy" id="yy" placeholder="년(4자)"
								maxlength="4" /> <select name="mm" id="mm">
									<option value="">월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select>
							</label> <input type="text" name="dd" id="dd" placeholder="일"
								maxlength="2" />
						</div>
						<div>
							<select name="question" id="question">
								<!--onchage: select안에 있는 옵션들의 값이 바꼈을때 명령이 실행
                   onclick을 안하는 이유: 키보드 사용자는 click을 할수 없으므로-->
								<option disabled selected>비밀번호 확인 질문을 선택하세요</option>
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
							</select> <input type="text" name="answer" id="answer"
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
								name="mobile" id="mobile" /> ex "-"없이 숫자만 입력
							</label>
						</div>
						<div>
							<label>이메일<input type="text" name="email_id"
								id="email_id" />@
							</label> <input type="text" name="email_add" id="email_add" /> <select
								name="email_sel" id="email_sel" onchange="change_email();">
								<!--onchage: select안에 있는 옵션들의 값이 바꼈을때 명령이 실행
                   onclick을 안하는 이유: 키보드 사용자는 click을 할수 없으므로-->
								<option value="">직접입력</option>
								<option value="naver.com">naver</option>
								<option value="gmail.com">gmail</option>
								<option value="nate.com">nate</option>
							</select>
						</div>
						<!-- <div>
                <label>주소<input type="text" name="postal_code" id="postal_code" /></label>
                <button type="button" onclick="search_address();">검색</button>
              </div>
              <div>
                <label>기본주소<input type="text" name="addr1" id="addr1" size="30" /></label>
              </div>
              <div>
                <label>상세주소<input type="text" name="addr2" id="addr2" size="30" /></label>
              </div>
              <div>
                <label
                  >약관동의<input type="checkbox" value="Y" name="agree" id="agree" />약관에
                  동의합니다.</label
                >
              </div> -->
						<div class="join_btn">
							<button type="button" onclick="history.back();">이전페이지로</button>
							<!-- (window삭제).history.back 뒤로가기/history.forward 앞으로가기-->
							<button type="button" onclick="joinform_check();">가입하기</button>
							<!-- 입력된 경우에 따라서 다르게 액션되면 button으로, 입력 값 상관 없이 무조건 보내기면 submit -->
							<!-- type을 submit으로 하여 전송하기를 하지말고, script가서 함수를 만들고 전송하기를 함 button onclick으로 함수를 불러옴 함수안에 문제가 있는 경우 return false;-->
						</div>
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
