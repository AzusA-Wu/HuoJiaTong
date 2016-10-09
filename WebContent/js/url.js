
function url(type, dataType, url) {
	$.ajax({
		url: url,
		type: type,
		dataType: dataType,
		error: function() {
			alert("error");
		},
		success: function(json) {
			alert(json);
		}
	});
}

function json(url) {
	var result = null;
	$.ajax({
		url: url,
		type: "get",
		dataType: "json",
		error: function() {
			alert("error");
		},
		success: function(json) {
			result = json;
		},
		async: false
	});
	return result;
}

function text(url) {
	var result = null;
	$.ajax({
		url: url,
		type: "get",
		dataType: "text",
		error: function() {
			alert("error");
		},
		success: function(text) {
			result = text;
		},
		async: false
	});
	return result;
}
