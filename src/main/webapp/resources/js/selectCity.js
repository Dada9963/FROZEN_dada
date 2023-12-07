$(function() {
	$(".where").click(function() {
		let where = $(this).data("value");
		let whereVal = $(this).attr("title");
		if (whereVal != null) {
			location.href = "select.city?where=" + where + "&whereVal=" + whereVal;
		} else {
			alert(where);
			location.href = "cityMap.go?city=" + where;
		}
	});
});