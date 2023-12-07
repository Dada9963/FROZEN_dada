$(function() {
    // 지도 초기화 함수
    function initMap() {
        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(37.3595704, 127.105399),
            zoom: 10
        });
    }

    // 주소를 좌표로 변환하는 함수
    function searchAddressToCoordinate(address) {
        naver.maps.Service.geocode({
            query: address
        }, function(status, response) {
            if (status === naver.maps.Service.Status.ERROR) {
                return alert('Something Wrong!');
            }
            if (response.v2.meta.totalCount === 0) {
                return alert('올바른 주소를 입력해주세요.');
            }
            var htmlAddresses = [],
                item = response.v2.addresses[0],
                point = new naver.maps.Point(item.x, item.y);

            if (item.roadAddress) {
                htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
            }
            if (item.jibunAddress) {
                htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
            }
            if (item.englishAddress) {
                htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
            }

            insertAddress(item.roadAddress, item.x, item.y);
        });
    }

    // 주소 검색 이벤트
    $(function(e) {
        searchAddressToCoordinate($('#address').val());
    });
    // 검색 정보를 테이블로 작성하고, 지도에 마커를 찍어주는 함수
    function insertAddress(address, latitude, longitude) {
        var mapList = "";
        mapList += "<tr>"
        mapList += "	<td>" + address + "</td>"
        mapList += "	<td>" + latitude + "</td>"
        mapList += "	<td>" + longitude + "</td>"
        mapList += "</tr>"

        $('#mapList').append(mapList);

        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(longitude, latitude),
            zoom: 14
        });
        var marker = new naver.maps.Marker({
            map: map,
            position: new naver.maps.LatLng(longitude, latitude),
        });
    }

    // 페이지 로드 시 초기화 함수 호출
    $(document).ready(function() {
        initMap();
    });
});