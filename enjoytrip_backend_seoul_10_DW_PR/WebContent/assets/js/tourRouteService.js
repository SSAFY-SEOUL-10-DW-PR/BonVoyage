var mapRoute = new kakao.maps.Map(containerRoute, options);
mapRoute.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
mapRoute.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

function slist(target) {
  // (A) SET CSS + GET ALL LIST ITEMS
  target.classList.add("slist");
  let items = target.getElementsByTagName("li"), current = null;

  // (B) MAKE ITEMS DRAGGABLE + SORTABLE
  for (let i of items) {
    // (B1) ATTACH DRAGGABLE
    i.draggable = true;

    // (B2) DRAG START - YELLOW HIGHLIGHT DROPZONES
    i.ondragstart = e => {
      current = i;
      for (let it of items) {
        if (it != current) { it.classList.add("hint"); }
      }
    };

    // (B3) DRAG ENTER - RED HIGHLIGHT DROPZONE
    i.ondragenter = e => {
      if (i != current) { i.classList.add("active"); }
    };

    // (B4) DRAG LEAVE - REMOVE RED HIGHLIGHT
    i.ondragleave = () => i.classList.remove("active");

    // (B5) DRAG END - REMOVE ALL HIGHLIGHTS
    i.ondragend = () => { for (let it of items) {
      it.classList.remove("hint");
      it.classList.remove("active");
      viewRoute();
    }};

    // (B6) DRAG OVER - PREVENT THE DEFAULT "DROP", SO WE CAN DO OUR OWN
    i.ondragover = e => e.preventDefault();

    // (B7) ON DROP - DO SOMETHING
    i.ondrop = e => {
      e.preventDefault();
      if (i != current) {
        let currentpos = 0, droppedpos = 0;
        for (let it=0; it<items.length; it++) {
          if (current == items[it]) { currentpos = it; }
          if (i == items[it]) { droppedpos = it; }
        }
        if (currentpos < droppedpos) {
          i.parentNode.insertBefore(current, i.nextSibling);
        } else {
          i.parentNode.insertBefore(current, i);
        }
      }
    };
  }
}

let selected = null;
    
function dragOver(e) {
    if (isBefore(selected, e.target)) {
      e.target.parentNode.insertBefore(selected, e.target);
    } else {
      e.target.parentNode.insertBefore(selected, e.target.nextSibling);
    }
}
    
function dragEnd() {
  selected = null;
  
}
    
function dragStart(e) {
  e.dataTransfer.effectAllowed = 'move';
  e.dataTransfer.setData('text/plain', null);
  selected = e.target;
}
    
function isBefore(el1, el2) {
  let cur;
    if (el2.parentNode === el1.parentNode) {
      for (cur = el1.previousSibling; cur; cur = cur.previousSibling) {
        if (cur === el2) return true;
      }
    }
    return false;
}

document.getElementById("routeView").addEventListener("click", function () {
  makeRoute();
});

function makeRoute() {
  let routeJson = localStorage.getItem("routeJson");
  console.log(typeof (routeJson));
  console.log(routeJson);
  let routes = JSON.parse(routeJson).routes;
  console.log(typeof (routes));
  console.log(routes);
  let routeList = ``;
  let routeNo = 1;
    routes.forEach((route) => {
      routeList += `<li name="routeElement"; id="${route.mapx},${route.mapy}";>${routeNo}. ${route.title} <button type="button" class="btn_img" id="img_btn"><img  src="assets/img/close.png"></button><input type="hidden" name="routeElements" value="${route.contentId},${route.contentTypeId},${route.title},${route.mapx},${route.mapy}"></li>
      `;
      routeNo++;
    });
   console.log(routeList);
  document.getElementById("sortlist").innerHTML = routeList;
  slist(document.getElementById("sortlist"));
  viewRoute();
}

var polyline;
function viewRoute() {
  refreshRoute();
console.log(localStorage.getItem("routeJson"));
  var routeList = document.getElementsByName("routeElement");
  console.log(routeList);
  let routeNo = 1;
  let markerPosition;
  let markerSeq = [];
  let routeBounds = new kakao.maps.LatLngBounds();
  if (polyline != undefined||polyline!=null) { 
  polyline.setMap(null);
}
  console.log(routeList.length)
  routeList.forEach((routeLoc) => {
    var routeLocXY = routeLoc.id.split(",");
    let routeHidden = document.getElementById(routeLoc.id).childNodes;
//    console.log(routeHidden);
//    console.log(routeHidden.item(1));
//    console.log(typeof(routeHidden.item(1)));
//    console.log(routeHidden[2]);
    let btn = document.createElement("img");
    btn.setAttribute("src", "assets/img/close.png");
    btn.setAttribute("class", "btn_img");
    btn.setAttribute("onclick", "deleteRouteElement(this)");
    let hiddenInput = document.createElement("input");
    hiddenInput.setAttribute("type", "hidden");
    hiddenInput.setAttribute("name", "routeElements");
    hiddenInput.setAttribute("id", routeHidden[2].value);
    hiddenInput.setAttribute("value", routeHidden[2].value);
    console.log(hiddenInput);
    addSchedule(hiddenInput);
    
    routeLoc.innerHTML = routeNo + ". " + routeLoc.innerText.slice(3);
    routeLoc.appendChild(btn);
    routeLoc.appendChild(hiddenInput);
//  routeLoc.append(routeHidden.item(1));
//  routeLoc.append(routeHidden[2]);
    var imageSrc = `assets/img/marker/route/${routeNo}.png`; // 마커이미지의 크기입니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, new kakao.maps.Size(42, 50), { offset: new kakao.maps.Point(20, 45) });
    markerPosition = new kakao.maps.LatLng(Number(routeLocXY[1]), Number(routeLocXY[0]));
      var markerRoute = new kakao.maps.Marker({
        position: markerPosition, 
        image: markerImage // 마커이미지 설정 
      });
      mapRoute.setLevel(6);
    markerRoute.setMap(mapRoute);  
    markerSeq.push(markerPosition);
    routeBounds.extend(markerPosition);
    routeNo++;
  });

  polyline = new kakao.maps.Polyline({
    path: markerSeq, // 선을 구성하는 좌표배열 입니다
    strokeWeight: 7, // 선의 두께 입니다
    strokeColor: 'black', // 선의 색깔입니다
    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'solid' // 선의 스타일입니다
  });
  polyline.setMap(mapRoute);  
  mapRoute.setBounds(routeBounds);
}

function deleteRouteElement(select){
	let deleteLi=select.parentElement;
	deleteLi.parentElement.removeChild(deleteLi);
	viewRoute();
}

function refreshRoute(){
	localStorage.removeItem("routeJson");
	routes.length=0;
}

function viewLatestRoute(root) {
	 
	  let location = root+"/route?action=load&type=latest";
		refreshRoute();
	   console.log(location);
	  fetch(location)
	    .then((response) => response.json())
	    .then((data) => makeSavedRouteList(data));
	}

function makeSavedRouteList(data) {
	  console.log(data);
	  data.forEach(element => {
	    var hiddenInput = document.createElement("a");
	    hiddenInput.setAttribute("id", element.routeElement.split("/")[0]);
	    addSchedule(hiddenInput);
	  });
	  makeRoute();
	}




