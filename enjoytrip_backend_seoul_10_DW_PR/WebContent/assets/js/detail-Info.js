let title = "";
let info = "";
let img = "";
let desc = "";
let tripDetail=null,tripImg=null;
let rootLoc="";
async function viewDetail(select) {
  var str = select.id.split(",");
  var contentId = str[0];
  var contentTypeId = str[1];
  title = str[2];
  let serviceKey = `ItKuQSxKLd76EK5vnch0CVWfvLJ%2BXlM6%2FKpDipWck41TMJhrL8pvFUdtSiDlJMydRvJtkC1%2Ftqd9WRVcNw3S1w%3D%3D`;
  let introURL = `https://apis.data.go.kr/B551011/KorService1/detailIntro1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&contentId=`;
  let imgURL = `https://apis.data.go.kr/B551011/KorService1/detailImage1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&contentId=`;
  let descURL = `https://apis.data.go.kr/B551011/KorService1/detailCommon1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&contentId=`;
  let detailURL =
    introURL + contentId + "&contentTypeId=" + contentTypeId + "&numOfRows=10&pageNo=1";
  let imageSrc = imgURL + contentId + "&imageYN=Y&subImageYN=Y&numOfRows=10&pageNo=1";
  let descSrc =
    descURL +
    contentId +
    "&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&numOfRows=10&pageNo=1";
  await fetch(detailURL)
    .then((response) => response.json())
    .then((data) => infoList(data));

  await fetch(imageSrc)
    .then((response) => response.json())
    .then((data) => imgList(data));

  await fetch(descSrc)
    .then((response) => response.json())
    .then((data) => descList(data));
}

function infoList(data) {
  var trips = data.response.body.items.item;
  tripDetail=trips;
/*  var site = "";
  var infolist = `<h3>${title}</h3>
  <ul>`;
  trips.forEach((area) => {
    if (area.contenttypeid == "12") {
      site = "관광지";
      infolist += `<li><strong>분류</strong> : ${site}</li>
      <li><strong>이용 문의</strong> : ${area.infocenter}</li>
        <li><strong>휴무일</strong> : ${area.restdate}</li>
        <li><strong>이용 시간</strong> : ${area.usetime}</li>
        <li><strong>주차 가능 여부</strong> : ${area.parking}</li>`;
    }
    if (area.contenttypeid == "32") {
      site = "숙박시설";
      infolist += `<li><strong>분류</strong> : ${site}</li>
        <li><strong>방 개수</strong> : ${area.roomcount}</li>
        <li><strong>체크인 / 체크아웃</strong> : ${area.checkintime} ~ ${area.checkouttime}</li>
        <li><strong>편의 시설</strong> : ${area.subfacility}</li>`;
    }
    if (area.contenttypeid == "39") {
      site = "음식점";
      infolist += `<li><strong>분류</strong> : ${site}</li>
        <li><strong>주 메뉴</strong> : ${area.treatmenu}</li>
        <li><strong>전화번호</strong> : ${area.infocenterfood}</li>
        <li><strong>이용 시간</strong> : ${area.opentimefood}</li>
        <li><strong>휴무일</strong> : ${area.restdatefood}</li>`;
    }
    infolist += `</ul>`;
  });

  info = infolist;
  localStorage.setItem("info", info);*/
}

function imgList(data) {
  var trips = data.response.body.items.item;
  tripImg=trips;
/*  var site = "";
  var imglist = ``;
  trips.forEach((area) => {
    if (area.originimgurl != "")
      imglist += `<div class="swiper-slide">
    <img src="${area.originimgurl}" alt="" />
  </div>`;
  });
  img = imglist;
  localStorage.setItem("img", img);*/
}

function descList(data) {
  var trips = data.response.body.items.item;
  var site = "";
  trips.forEach((area) => {
    desc = area.overview;
  });

/*  localStorage.setItem("desc", desc);*/
/*  window.location.href = "./portfolio-details.jsp";*/
//  window.open("/enjoytrip_backend_seoul_10_DW_PR/detail?action=save");


   var form = document.createElement('form');
    form.setAttribute('method', 'post'); //POST 메서드 적용
    form.setAttribute('action', "/enjoytrip_backend_seoul_10_DW_PR/attraction?action=detail");	// 데이터를 전송할 url
    document.charset = "utf-8";
    var hiddenField = document.createElement('input');
    hiddenField.setAttribute('type', 'hidden'); //값 입력
    hiddenField.setAttribute('name', "tripDetail");
    hiddenField.setAttribute('value', JSON.stringify(tripDetail));
    form.appendChild(hiddenField);
    var hiddenField1 = document.createElement('input');
    hiddenField1.setAttribute('type', 'hidden'); //값 입력
    hiddenField1.setAttribute('name', "tripImg");
    hiddenField1.setAttribute('value', JSON.stringify(tripImg));
    form.appendChild(hiddenField1);
    var hiddenField4 = document.createElement('input');
    hiddenField4.setAttribute('type', 'hidden'); //값 입력
    hiddenField4.setAttribute('name', "desc");
    hiddenField4.setAttribute('value', desc);
    form.appendChild(hiddenField4);
    var hiddenField3 = document.createElement('input');
    hiddenField3.setAttribute('type', 'hidden'); //값 입력
    hiddenField3.setAttribute('name', "title");
    hiddenField3.setAttribute('value', title);
    form.appendChild(hiddenField3);
    
    document.body.appendChild(form);
    console.log(tripImg);
console.log(desc);
console.log(typeof(desc));
console.log(tripDetail);
    form.target="_blank";
    form.submit();	// 전송~
}
