var marker, infowindow;
var container = document.getElementById("map");
var containerRoute=document.getElementById("map-route");
var myLatLng = new kakao.maps.LatLng(37.5012743, 127.039585);
var options = {
  center: myLatLng,
  level: 3,
};

var map = new kakao.maps.Map(container, options);

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);



// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
if (navigator.geolocation) {
  // GeoLocation을 이용해서 접속 위치를 얻어옵니다
  navigator.geolocation.getCurrentPosition(function (position) {
    var lat = position.coords.latitude, // 위도
      lon = position.coords.longitude; // 경도

    (myLatLng = new kakao.maps.LatLng(lat, lon)), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
      (message = '<div style="padding:5px;">나여기있어요</div>'); // 인포윈도우에 표시될 내용입니다

    // 마커와 인포윈도우를 표시합니다
    displayMarker(myLatLng, message);
  });
} else {
  // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

  (myLatLng = new kakao.maps.LatLng(37.5012743, 127.039585)),
    (message = "geolocation을 사용할수 없어요..");

  displayMarker(myLatLng, message);
}
function removeMarkers(markers) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }            
  markers = [];
}
// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(myLatLng, message, markerImage) {
  // 마커를 생성합니다
  marker = new kakao.maps.Marker({
    map: map,
    position: myLatLng,
    image: markerImage, // 마커이미지 설정
  });

  var iwContent = message, // 인포윈도우에 표시할 내용
    iwRemoveable = true;

  // 인포윈도우를 생성합니다
  infowindow = new kakao.maps.InfoWindow({
    content: iwContent,
    removable: iwRemoveable,
  });

  // 인포윈도우를 마커위에 표시합니다
  // infowindow.open(map, marker);

  // 지도 중심좌표를 접속위치로 변경합니다
  map.setCenter(myLatLng);

  // 마커에 마우스오버 이벤트를 등록합니다
  kakao.maps.event.addListener(marker, "mouseover", function () {
    // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
    infowindow.open(map, marker);
  });

  // 마커에 마우스아웃 이벤트를 등록합니다
  kakao.maps.event.addListener(marker, "mouseout", function () {
    // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
    infowindow.close();
  });
}

// 지점 선택시 지도 이동.
let offices = document.querySelectorAll(".accordion-body");
offices.forEach(function (office) {
  office.addEventListener("click", function () {
    viewMarker(this);
  });
});

function viewMarker(office) {
  officeLatLng = officePosition[office.textContent];
  marker.setMap(null);
  myLatLng = new kakao.maps.LatLng(officeLatLng.lat, officeLatLng.lng);
  let message = `<div style="padding:5px;">${office.textContent}</div>`;
  const imageSrc = "../assets/img/ssafy_logo.png"; // 마커이미지의 주소입니다
  let imageSize = new kakao.maps.Size(50, 54); // 마커이미지의 크기입니다
  let imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

  // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);

  displayMarker(myLatLng, message, markerImage);
}

// =============================================================================================================================================================

