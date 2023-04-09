# 서울 10반 EnjoyTrip 관통 프로젝트

<p align="center">
  <br>
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3gLsznyvXmyYnfvz44cJJOt1vtoFwuNfgYeZIapie_g&s">
  <br>
</p>


##  📑 프로젝트 개요

### - 프로젝트 소개
<aside>
💡 지역 경기 침체에 도움을 주고자 지역 관광 활성화를 위한 지역 관광 소개 페이지
</aside>
       
      
    

## 🛠 구현 기능

- 필수  
#1. 지역별 / 유형별 여행지 검색  
#2. 게시판 기능    
#3. 로그인 및 회원 관리 기능(마이페이지)

- 추가 및 심화  
#1. 여행 경로 설정 및 변경   
#2. 경로 저장 및 최근 경로 불러오기   
#3. 상세 정보 제공   
#4. 여행지 별 리뷰 제공

<hr/>

## 📌활용

| HTML  |  CSS  |  JS   | AJAX  |  JSP  | Java  |  MVC  |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
<br>

---
## :page_with_curl: DB 설계

> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/Copy%20of%20EnjoyTrip.png "DB")

## :pencil2: 요구 사항

> ###  F01) 지역별 관광지 정보 수집
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F01.png "지역별 관광지 정보 보기")
>
> <hr/>
>
> ### Description
>
> - 한국관광공사 : 지역별 관광지
정보를 얻어와 화면에 표시

<hr/>

> ### F02) 관광지, 숙박, 음식점 조회
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F02.png "관광지, 숙박, 음식점 조회")
>
> <hr/>
>
> ### Description
>
> - 관광지 정보를 지역별 원하는
컨텐츠 별 조회.

<hr/>
  
> ### F03) 문화시설, 공연, 여행코스, 쇼핑 조회
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F03.png "문화시설, 공연, 여행코스, 쇼핑 조회")
>
> <hr/>
>
> ### Description
>
> - 관광지 정보를 지역별 원하는
컨텐츠 별 조회.

<hr/>

> ### F04) 여행 계획 경로 설정
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F04.png "여행 계획 경로 설정")
>
> <hr/>
>
> ### Description
>
> - 조회한 관광지를 활용하여 여행
계획, 여행 경로를 저장

<hr/>

> ### F05) 경로 순서 변경
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F05.png "경로 순서 변경")
>
> <hr/>
>
> ### Description
>
> - 경로 변경 시 수정한 경로대로 화면에 표시

<hr/>

> ### F06) 상세 정보
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F06.png "상세 정보")
>
> <hr/>
>
> ### Description
>
> - 관광지 정보를 크롤링하여 상세 정보 제공

<hr/>

> ### F07) 회원 관리
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F07.png "회원 관리")
>
> <hr/>
>
> ### Description
>
> - 회원가입, 수정, 조회, 탈퇴

<hr/>

> ### F08) 로그인 관리
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F08.png "로그인 관리")
>
> <hr/>
>
> ### Description
>
> - 로그인 / 로그아웃 / 비밀번호
찾기

<hr/>

> ### F09) 공지사항
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F09.png "공지사항")
>
> <hr/>
>
> ### Description
>
> - 공지사항 등록, 수정, 삭제, 조회

<hr/>

> ### F10) 지도 내 위치 클릭 시 이동
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F10.png "지도 내 위치 클릭 시 이동")
>
> <hr/>
>
> ### Description
>
> - 지도 내 위치 클릭 시 화면 중앙으로 이동

<hr/>

> ### F11) 비밀번호 찾기 기능
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F11-1.png "비밀번호 찾기")
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F11-2.png "비밀번호 찾기")
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F11-3.png "비밀번호 찾기")
>
> <hr/>
>
> ### Description
>
> - 회원가입 시 입력한 비밀번호 질문 및 답변 통해 새 비밀번호 설정 가능

<hr/>

> ### F12) 회원 정보 수정 및 탈퇴
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F12.png "비밀번호 찾기")
>
> <hr/>
>
> ### Description
>
> - 마이페이지에서 회원정보 수정 페이지에서 정보 수정 및 회원 탈퇴 기능(사용자 정보 창 조회 시 기존 정보 자동으로 불러옴)

<hr/>

> ### F13) 리뷰 작성 및 조회
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F13-1.png "리뷰 작성 및 조회")
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F13-2.png "리뷰 작성 및 조회")
>
> <hr/>
>
> ### Description
>
> - 상세 정보 창 내 리뷰 작성 및 작성한 리뷰 조회 가능

<hr/>

> ### F14) 저장한 최근 경로 불러오기
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F14.png "최근 저장한 경로 불러오기")
>
> <hr/>
>
> ### Description
>
> - 최근 저장한 경로 불러오기 버튼을 통해 경로 불러오기 가능

<hr/>

> ### F15) 저장한 경로 조회
>
> ### 이미지 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/F15.png "저장한 경로들 조회")
>
> <hr/>
>
> ### Description
>
> - 경로저장 버튼 통해 저장한 경로들 마이페이지 내 저장한 경로 창에서 조회 가능

<hr/>

- ### 화면 설계 예시
  > - 메인 화면
  >   ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/%EB%A9%94%EC%9D%B8%20%ED%99%94%EB%A9%B4.png "메인 화면")

<hr/>

## :pencil2: 추가 기능 #1 경로 설정

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/additional01.gif "경로 설정")
>
> <hr/>
>
> ### Description
>
> - 장소 검색 후 일정에 추가하여 경로 설정
<hr/>

## :pencil2: 추가 기능 #2 경로 순서 변경

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/additional02.gif "경로 순서 변경")
>
> <hr/>
>
> ### Description
>
> - 추가된 경로들의 순서 변경

<hr/>

## :pencil2: 추가 기능 #3 경로 저장 및 경로 불러오기

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/additional03.gif "경로 저장 및 불러오기")
>
> <hr/>
>
> ### Description
>
> - 저장된 경로 불러오기

<hr/>

## :pencil2: 심화 기능 #1 상세 정보

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/advanced01.gif "상세 정보 보기")
>
> <hr/>
>
> ### Description
>
> - 원하는 장소의 상세 정보 클릭 시 이용 시간 등의 상세 정보 제공

<hr/>

## :pencil2: 심화 기능 #2 리뷰

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/advanced02.gif "리뷰 보기")
>
> <hr/>
>
> ### Description
>
> - 상세 정보 창에서 리뷰 작성 및 리뷰 정보 공유 기능

<hr/>

## :pencil2: 심화 기능 #3 공지사항

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/advanced03.gif "공지사항")
>
> <hr/>
>
> ### Description
>
> - 게시글 및 글 등록, 수정, 조회가 가능한 공지사항 게시판

<hr/>

## :pencil2: 심화 기능 #4 지도 내 위치 클릭 시 이동

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/advanced04.gif "지도 내 위치 클릭 시 이동")
>
> <hr/>
>
> ### Description
>
> - 장소 검색 시 화면 중앙에 지정한 장소가 위치하도록 설정

<hr/>

## :pencil2: 심화 기능 #5 마이페이지

> ### 화면 예시
>
> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/advanced05.gif "마이페이지")
>
> <hr/>
>
> ### Description
>
> - 회원 정보 조회 및 수정, 저장한 경로 및 작성한 리뷰 조회

<hr/>

## :sparkles: 최종 결과물 화면 예시

> ![Alt text](/enjoytrip_backend_seoul_10_DW_PR/WebContent/assets/screenshots/finalResult.gif "최종 결과물")
