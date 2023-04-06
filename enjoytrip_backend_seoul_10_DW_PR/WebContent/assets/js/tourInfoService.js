let serviceKey =
  "uYKEW8VG36vvR1HGmSFC4M24BIXNzNiWda%2BD6PCMcxh5aZWdYMn0nn057fh00q0sZvBGSUypjzDmEGdqlsNwsQ%3D%3D";

let areaUrl =
  "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
  serviceKey +
  "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

// //ajax로 불러오려고 fetch 사용!
//fetch(areaUrl,{method: "GET"})//겟 생략 가능(어차피 보내는 인자 없으니까)
fetch(areaUrl) //첫번쨰 인자값은 url
  .then((response) => response.json()) //then을 쓰면 내부적으로 처리되는게 많아서 좋음.
  //위에서 넘겨준 값을 response로 받아서 json으로 바꿈!
  //then(function (response) { return response.json() }) 이렇게 써도 됨(화살표 함수)
  .then((data) => makeOption(data));

function makeOption(data) {
  // console.log(data);
  let areas = data.response.body.items.item;
  let sel = document.getElementById("area-category");
  //areas.forEach((area)=>{}) //이렇게 써도 됨
  areas.forEach(function (area) {
    let opt = document.createElement("li"); // <option></option>
    // <option value="1">서울</option>
    opt.setAttribute("class", "dropdown-item");
    opt.setAttribute("onclick", "setAreaCode(this)");
    opt.setAttribute("value", area.code);
    opt.appendChild(document.createTextNode(area.name));
    sel.appendChild(opt);
  });
}

document.getElementById("dropdownMenu").addEventListener("click", function () {
  let sel = document.getElementById("sigungu-category");
  sel.innerHTML = `<li class="dropdown-item" value="0" onclick="setSigungu(this)">선택안함</li>`;
  let areaCode = document.getElementById("dropdownMenuOffset").value;
  // console.log(areaCode);
  let areaUrl2 =
    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
    serviceKey +
    "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=" +
    areaCode +
    "&_type=json";

  fetch(areaUrl2) //첫번쨰 인자값은 url
    .then((response) => response.json()) //then을 쓰면 내부적으로 처리되는게 많아서 좋음.
    //위에서 넘겨준 값을 response로 받아서 json으로 바꿈!
    //then(function (response) { return response.json() }) 이렇게 써도 됨(화살표 함수)
    .then((data) => makeOption(data));

  function makeOption(data) {
    console.log(data);
    let areas = data.response.body.items.item;
    let sel = document.getElementById("sigungu-category");
    //areas.forEach((area)=>{}) //이렇게 썯 됨
    areas.forEach(function (area) {
      let opt = document.createElement("li"); // <option></option>
      // <option value="1">서울</option>
      opt.setAttribute("class", "dropdown-item");
      opt.setAttribute("onclick", "setSigungu(this)");
      opt.setAttribute("value", area.code);
      opt.appendChild(document.createTextNode(area.name));
      sel.appendChild(opt);
    });
  }
});
var mapMarker = [];
document.getElementById("btn-search-keyword").addEventListener("click", function () {
  let search = document.getElementById("search-keyword").value;
  let areaCode = document.getElementById("dropdownMenuOffset").value;
  let sigunguCode = document.getElementById("dropdownMenu").value;
  let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
  if (areaCode != "0") {
    searchUrl += `&areaCode=${areaCode}`;
  }
  if (sigunguCode != "0") {
    searchUrl += `&sigunguCode=${sigunguCode}`;
  }
  if (!search) {
    alert("검색어를 입력하세요");
    return;
  } else {
    searchUrl += `&keyword=${search}`;
  }

  removeMarkers(mapMarker)
  // console.log(searchUrl);
  fetch(searchUrl)
    .then((response) => response.json())
    .then((data) => makeList(data));
});

var selectedMarker=null;
var selectCustomOverlay=null;
function makeList(data) {
  // console.log(data);
  let trips = data.response.body.items.item;
  let triplist = ``;
  let no = 1;

  var listBounds = new kakao.maps.LatLngBounds();
  trips.forEach((area) => {
    triplist += `
    <tr onclick="setDestination(this)" id="${area.mapx},${area.mapy}" value="${area.contentid},${area.contenttypeid},${area.title},${area.mapx},${area.mapy}">
    <td>${no}</td>
      <td>${area.title}</td>
      <td>${area.addr1}</td>
    </tr>`;
    var imageSrc = `assets/img/marker/${area.contenttypeid}.png`, // 마커이미지의 주소입니다
      imageSize = new kakao.maps.Size(60, 60), // 마커이미지의 크기입니다
      imageOption = { offset: new kakao.maps.Point(30, 90) };
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
    markerPosition = new kakao.maps.LatLng(area.mapy, area.mapx);
    var marker = new kakao.maps.Marker({
      position: markerPosition,
      image: markerImage, // 마커이미지 설정
    });
    marker.setMap(map);
    mapMarker.push(marker);
    listBounds.extend(markerPosition);
    

    var content = `<div class="customoverlay"> 
    	   <span href="javascript:void(0);" onclick="setDestination(this)"; id="${area.mapx},${area.mapy}" target="_blank" value="${area.contentid},${area.contenttypeid},${area.title},${area.mapx},${area.mapy}"><span class="title">${area.title}</span></span> 
    	 </div>`;
    	    var overlayPosition=new kakao.maps.LatLng(area.mapy, area.mapx);
    	    var customOverlay = new kakao.maps.CustomOverlay({
    	      map: map,
    	      position: overlayPosition,
    	      content: content,
    	      yAnchor: 1 
    	    });
    	    customOverlay.setMap(null);
    	kakao.maps.event.addListener(marker, "mouseover", function () {
    	  // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
    	  customOverlay.setMap(map);
    	});

    	//클릭할시 오버레이 띄워놓음
    	kakao.maps.event.addListener(marker, 'click', function() {
    		  selectedMarker = marker;
    		  
    		  customOverlay.setMap(map);
    		  if(selectCustomOverlay!=null){
    		  selectCustomOverlay.setMap(null);}
    		  selectCustomOverlay=customOverlay;
    		});

    	//
    	kakao.maps.event.addListener(marker, "mouseout", function () {
    		 if (!selectedMarker || selectedMarker != marker) {
    		   customOverlay.setMap(null);
    		  }
    		 });
    no = no + 1;
  });
  map.setBounds(listBounds);
  document.getElementById("trip-list").innerHTML = triplist;
}
