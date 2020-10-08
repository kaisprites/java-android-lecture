<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <div id="map" style="display: inline-block; width:800px; height: 600px;"></div>
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJEalzBFAur1DlCax9kfJ0T4Kh8j87WAc&callback=initMap"></script>
  <script>
    function initMap() {
      var hamduk = { lat: 33.5437905 ,lng: 126.6666554 };
      var jejuairport = { lat: 33.5086982, lng: 126.489968 };
      var leejungseop = { lat: 33.2416401, lng: 126.523441 };
      var map = new google.maps.Map(
        document.getElementById('map'), {
          zoom: 10,
          center: jejuairports
        });
      
      new google.maps.Marker ({
    	  position: hamduk,
    	  map: map,
    	  label: "함덕해수욕장"
      })
      
      new google.maps.Marker ({
    	  position: jejuairport,
    	  map: map,
    	  label: "제주국제공항"
      })
      
      new google.maps.Marker ({
    	  position: leejungseop,
    	  map: map,
    	  label: "이중섭거리"
      })
    }
  </script>
</body>
</html>