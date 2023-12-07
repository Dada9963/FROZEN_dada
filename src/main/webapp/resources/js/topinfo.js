$(function() {
	let where = $(".whereValue").val();
//	alert(where);
	$.getJSON("topInfo.ajax?where=" + where, function(top) {
		$("#topInfoDiv").empty();
		$.each(top.topInfo, function(i, t) {
			if (t.imgResult != null) {
				let div1 = $("<div></div>").text(t.nameResult);
				let img = $("<img>").attr("src", t.imgResult);
				let address = t.address.replaceAll("&", "!");
//				alert(address);
				let aTag1 = $("<a></a>").attr("href", "selectList.map?address=" + address).append(div1);
				let aTag2 = $("<a></a>").attr("href", "selectList.map?address=" + address).append(img);
				$("#topInfoDiv").append(aTag1," <br>", aTag2, "<br>");
				
				console.log(t.nameResult);
				console.log(t.imgResult);
			} else {
				let div1 = $("<div></div>").text(t.nameResult);
				let address = t.address.replaceAll("&", "!");
//				alert(address);
				let aTag1 = $("<a></a>").attr("href", "selectList.map?address=" + address).append(div1);
				console.log(t.nameResult);
				$("#topInfoDiv").append(aTag1," <br>");
			}
		});
	});
});