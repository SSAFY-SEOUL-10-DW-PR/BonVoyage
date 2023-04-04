let recommendUrl = `https://apis.data.go.kr/B551011/KorService1/locationBasedList1?serviceKey=${serviceKey}&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
let routes = new Array();

var prevSelectId = "";
function setDestination(select) {
  // console.log(prevSelectId);
  if (prevSelectId != "") {
    if (document.getElementById(prevSelectId) != null) {
      document.getElementById(prevSelectId).style = "";
    }
  }
  select.style.backgroundColor = "#99d2ec";
  prevSelectId = select.id;
  var str = select.id.split(",");
  var mapx = str[0];
  var mapy = str[1];

  map.setCenter(new kakao.maps.LatLng(mapy, mapx));

  let location = recommendUrl + "&mapX=" + mapx + "&mapY=" + mapy + "&radius=5000";

  // console.log(location);
  fetch(location)
    .then((response) => response.json())
    .then((data) => recommendList(data));
}

/**
 * Easy event listener function
 */
function recommendList(data) {
  // console.log(data);
  var trips = data.response.body.items.item;
  // var recommendlist = `<div class="row portfolio-container" data-aos="fade-up">`;
  var recommendlist = "";
  var site = "";
  var attractionNo = 1;
  var accommodationNo = 1;
  var restaurantNo = 1;
  var No = 1;
  var imgsrc = "";
  trips.forEach((area) => {
    if (area.firstimage != "") imgsrc = area.firstimage;
    else {
      imgsrc = "assets/img/noimg.jfif";
    }
    if (area.contenttypeid != "12" && area.contenttypeid != "32" && area.contenttypeid != "39")
      return;
    if (area.contenttypeid == "12") {
      site = "attraction";
      attractionNo++;
    }
    if (area.contenttypeid == "32") {
      site = "accommodation";
      accommodationNo++;
    }
    if (area.contenttypeid == "39") {
      site = "restaurant";
      restaurantNo++;
    }
    recommendlist += `<div class="col-lg-4 col-md-6 portfolio-item filter-${site}">
      <div class="portfolio-wrap">
        <div style="background-color : #F4F6F7; text-align : center; font-weight:bold;">${area.title}</div>
        <img src="${imgsrc}" class="img-fluid" alt=""/>
        <div class="portfolio-links">
          <a
            href='javascript:void(0);'
            data-gallery="portfolioGallery"
            class="portfolio-lightbox"
            title="${area.title}"
            id = "${area.title},${area.mapx},${area.mapy},${area.contentid},${area.contenttypeid}"
            onclick="addSchedule(this)"
            ><i class="bx bx-plus"></i
          ></a>
          <a href="#" title="More Details" onclick = "viewDetail(this)" id="${area.contentid},${area.contenttypeid},${area.title}"
            ><i class="bx bx-link"></i
          ></a>
        </div>
      </div>
    </div>`;

    //     var loc = new Object();
    // loc.title = area.title;
    // loc.mapx = area.mapx;
    // loc.mapy = area.mapy;
  });

  document.getElementById("portfolio-container").innerHTML = recommendlist;
  // var routeJson = JSON.stringify(routes);
  // console.log(routeJson)

  let portfolioContainer = select(".portfolio-container");
  //let portfolioContainer=document.getElementById("portfolio-container");
  // console.log(portfolioContainer);
  if (portfolioContainer) {
    let portfolioIsotope = new Isotope(portfolioContainer, {
      itemSelector: ".portfolio-item",
      layoutMode: "fitRows",
      filter: ".filter-cof",
    });

    let portfolioFilters = select("#portfolio-flters li", true);

    on(
      "click",
      "#portfolio-flters li",
      function (e) {
        e.preventDefault();
        portfolioFilters.forEach(function (el) {
          el.classList.remove("filter-active");
        });

        this.classList.add("filter-active");
        // console.log(this.classList);

        // console.log(this.getAttribute("data-filter"));
        portfolioIsotope.arrange({
          filter: this.getAttribute("data-filter"),
        });
        portfolioIsotope.on("arrangeComplete", function () {
          AOS.refresh();
        });
      },
      true
    );	
  }
}

function addSchedule(select) {
  var str = select.id.split(",");
  let loc = {
    title: str[0],
    mapx: str[1],
    mapy: str[2],
    contentId: str[3],
    contentTypeId: str[4],
  };

  routes.push(loc);

  var routeJson = {
    routes: routes,
  };
  localStorage.setItem("routeJson", JSON.stringify(routeJson));
}
