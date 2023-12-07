<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <!-- jQuery 스크립트 로딩 -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=m22u110whf&submodules=geocoder"></script>
    <script type="text/javascript" src="resources/js/selectList.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/topinfo.js"></script>
</head>
<body>
	<div class="search">
        <input id="address" type="hidden" value="${where }">
    </div>
    <div id="map" style="width:1000px;height:500px;"></div>
    <div>
        <table>
            <thead>
                <tr>
                    <th>주소</th>
                    <th>위도</th>
                    <th>경도</th>
                </tr>
            </thead>
            <tbody id="mapList"></tbody>
        </table>
    </div>
	<input class="whereValue" type="hidden" value="${where }">
	<div id="topInfoDiv"></div>
</body>
</html>