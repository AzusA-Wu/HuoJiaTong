function product_add_ajax() {
	$.ajax({
		url: "/add.do",
		type: "post",
		dataType: "json",
		data: {
			"brand_id" : $("select[name='brand_id']").val(),
			"color_id" : $("select[name='color_id']").val(),
			"size_id" : $("select[name='size_id']").val(),
			"stock" : $("input[name='stock']").val(),
			"standard_price" : $("input[name='standard_price']").val(),
			"remark" : $("#remark").val()
		},
		error: function() {
			alert("error");
		},
		success: function(json) {
			alert(json);
		}
	});
}

function product_add() {
	return true;
}

function layer_close() {
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    parent.layer.close(index);
}